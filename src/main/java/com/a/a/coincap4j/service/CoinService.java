package com.a.a.coincap4j.service;

import java.util.List;

import com.a.a.coincap4j.domain.Coin;
import com.a.a.coincap4j.domain.CoinMap;
import com.a.a.coincap4j.domain.FrontCoinData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoinService {
	
	@GET("coins")
	Call<List<String>> getCoinsListShort();
	
	@GET("map")
	Call<List<CoinMap>> getCoinsMap();
	
	@GET("front")
	Call<List<FrontCoinData>> getFrontCoinData();
	
	@GET("page/{coin}")
	Call<Coin> getCoin(@Path("coin") String coin);
	
}
