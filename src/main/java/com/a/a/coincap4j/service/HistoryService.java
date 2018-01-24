package com.a.a.coincap4j.service;

import java.util.List;

import com.a.a.coincap4j.domain.history.InternalHistoryRepresentation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HistoryService {
	
	@GET("history/{coin}")
	Call<List<InternalHistoryRepresentation>> getAllHistory(@Path("coin") String coin);
	
	@GET("history/1day/{coin}")
	Call<List<InternalHistoryRepresentation>> get1DayHistory(@Path("coin") String coin);
	
	@GET("history/7day/{coin}")
	Call<List<InternalHistoryRepresentation>> get7DayHistory(@Path("coin") String coin);
	
	@GET("history/30day/{coin}")
	Call<List<InternalHistoryRepresentation>> get30DayHistory(@Path("coin") String coin);
	
	@GET("history/90day/{coin}")
	Call<List<InternalHistoryRepresentation>> get90DayHistory(@Path("coin") String coin);
	
	@GET("history/180day/{coin}")
	Call<List<InternalHistoryRepresentation>> get180DayHistory(@Path("coin") String coin);
	
	@GET("history/365day/{coin}")
	Call<List<InternalHistoryRepresentation>> get365DayHistory(@Path("coin") String coin);
}
