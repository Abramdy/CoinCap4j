package com.a.a.coincap4j.service;

import com.a.a.coincap4j.domain.GlobalData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GlobalService {
	@GET("global")
	Call<GlobalData> getGlobalData();
}
