package com.a.a.coincap4j.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.a.a.coincap4j.domain.history.History;
import com.a.a.coincap4j.domain.history.InternalHistoryRepresentation;
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
	
	private Optional<List<History>> getHistory(Call<List<InternalHistoryRepresentation>> history) {
		return Util.wrapInOptional(() -> historyTransformer.apply(history.execute().body()));
	}
	
	public Optional<List<History>> all() {
		return getHistory(hs.getAllHistory(symbol));
	}
	
	public Optional<List<History>> day() {
		return getHistory(hs.get1DayHistory(symbol));
	}
	
	public Optional<List<History>> week() {
		return getHistory(hs.get7DayHistory(symbol));
	} 
	
	public Optional<List<History>> month() {
		return getHistory(hs.get30DayHistory(symbol));
	}
	
	public Optional<List<History>> quaterly() {
		return getHistory(hs.get90DayHistory(symbol));
	}
	
	public Optional<List<History>> halfYear() {
		return getHistory(hs.get180DayHistory(symbol));
	}
	
	public Optional<List<History>> year() {
		return getHistory(hs.get365DayHistory(symbol));
	}

}
