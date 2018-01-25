package com.a.a.coincap4j.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.a.a.coincap4j.domain.history.History;
import com.a.a.coincap4j.domain.history.InternalHistoryRepresentation;
import com.a.a.coincap4j.util.Either;
import com.a.a.coincap4j.util.Util;

import retrofit2.Call;

public class HistoryBuilder {
	
	private HistoryService hs;
	private String symbol;
	
	public HistoryBuilder(HistoryService hs, String symbol) {
		this.hs = hs;
	}
	
	private Function<List<InternalHistoryRepresentation>, List<History>> historyTransformer =
			ihrl -> ihrl.stream()
			.map(History::fromInternal)
			.collect(Collectors.toList());
	
	private Either<List<History>, Exception> getHistory(Call<List<InternalHistoryRepresentation>> history) {
		return Util.wrapInEither(() -> historyTransformer.apply(history.execute().body()));
	}
	
	public Either<List<History>, Exception> all() {
		return getHistory(hs.getAllHistory(symbol));
	}
	
	public Either<List<History>, Exception> day() {
		return getHistory(hs.get1DayHistory(symbol));
	}
	
	public Either<List<History>, Exception> week() {
		return getHistory(hs.get7DayHistory(symbol));
	} 
	
	public Either<List<History>, Exception> month() {
		return getHistory(hs.get30DayHistory(symbol));
	}
	
	public Either<List<History>, Exception> quaterly() {
		return getHistory(hs.get90DayHistory(symbol));
	}
	
	public Either<List<History>, Exception> halfYear() {
		return getHistory(hs.get180DayHistory(symbol));
	}
	
	public Either<List<History>, Exception> year() {
		return getHistory(hs.get365DayHistory(symbol));
	}

}
