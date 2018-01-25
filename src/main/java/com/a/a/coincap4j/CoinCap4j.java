package com.a.a.coincap4j;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.json.JSONObject;

import com.a.a.coincap4j.domain.Coin;
import com.a.a.coincap4j.domain.CoinMap;
import com.a.a.coincap4j.domain.FrontCoinData;
import com.a.a.coincap4j.domain.GlobalData;
import com.a.a.coincap4j.service.CoinService;
import com.a.a.coincap4j.service.GlobalService;
import com.a.a.coincap4j.service.HistoryBuilder;
import com.a.a.coincap4j.service.HistoryService;
import com.a.a.coincap4j.util.Either;
import com.a.a.coincap4j.util.Util;

import io.socket.client.IO;
import io.socket.client.Socket;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class CoinCap4j {
	
	public static final String BASE_URL = "http://coincap.io/";
	
	private Retrofit retrofit;
	private GlobalService gs;
	private CoinService cs;
	private HistoryService hs;
	
	private CoinCap4j() {}
	
	public static CoinCap4j instance() {
		CoinCap4j instance = new CoinCap4j();
		instance.retrofit = new Retrofit.Builder()
			    .baseUrl(BASE_URL)
			    .addConverterFactory(JacksonConverterFactory.create())
			    .build();
		instance.gs = instance.retrofit.create(GlobalService.class);
		instance.cs = instance.retrofit.create(CoinService.class);
		instance.hs = instance.retrofit.create(HistoryService.class);
		return instance;
	}
	
	public Either<GlobalData, Exception> getGlobalData() {
		Call<GlobalData> listRepos = gs.getGlobalData();
		return Util.wrapInEither(() -> listRepos.execute().body());
	}
	
	public Either<List<String>, Exception> getCoinsListShort() {
		Call<List<String>> coinsListShort = cs.getCoinsListShort();
		return Util.wrapInEither(() -> coinsListShort.execute().body());
	}
	
	public Either<List<CoinMap>, Exception> getCoinsMap() {
		Call<List<CoinMap>> coinsMap = cs.getCoinsMap();
		return Util.wrapInEither(() -> coinsMap.execute().body());
	}
	
	public Either<List<FrontCoinData>, Exception> getFrontCoinData() {
		Call<List<FrontCoinData>> frontCoinData = cs.getFrontCoinData();
		return Util.wrapInEither(() -> frontCoinData.execute().body());
	}
	
	public Either<Coin, Exception> getCoin(String symbol) {
		Call<Coin> coin = cs.getCoin(symbol);
		return Util.wrapInEither(() -> coin.execute().body());
	}
	
	public List<Either<Coin, Exception>> getCoins(List<String> coins) {
		List<Either<Coin, Exception>> list = new ArrayList<>();
		coins.forEach(c -> list.add(getCoin(c)));
		return list;
	}
	
	public HistoryBuilder history(String coin) {
		return new HistoryBuilder(hs, coin);
	}
	
	public void trades(Consumer<JSONObject> dataConsumer) throws URISyntaxException {
		Socket socket = IO.socket(BASE_URL);		
		socket.on("trades", (args) -> {
				dataConsumer.accept((JSONObject)args[0]);
			});		
		socket.connect();		
	}	

}
