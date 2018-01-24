package com.a.a.coincap4j.domain.history;

import java.util.List;
import java.util.stream.Collectors;

public class History {
	
	private List<HistoricMarketCap> marketCap;
	
	private List<HistoricPrice> price;
	
	private List<HistoricVolume> volume;
	
	private History() {
		// 
	}

	public static History fromInternal(InternalHistoryRepresentation ihr) {
		History history = new History();
		
		List<List<String>> ihrMarketCap = ihr.marketCap;
		history.marketCap = ihrMarketCap.stream()
					.map(l -> new HistoricMarketCap(l.get(0), l.get(1)))
					.collect(Collectors.toList());
		
		List<List<String>> ihrPrice = ihr.price;
		history.price = ihrPrice.stream()
				.map(l -> new HistoricPrice(l.get(0), l.get(1)))
				.collect(Collectors.toList());
		
		List<List<String>> ihrVolume = ihr.volume;
		history.volume = ihrVolume.stream()
				.map(l -> new HistoricVolume(l.get(0), l.get(1)))
				.collect(Collectors.toList());
		
		return history;
	}

	public List<HistoricMarketCap> getMarketCap() {
		return marketCap;
	}

	public List<HistoricPrice> getPrice() {
		return price;
	}

	public List<HistoricVolume> getVolume() {
		return volume;
	}

	@Override
	public String toString() {
		return "History [marketCap=" + marketCap + ", price=" + price + ", volume=" + volume + "]";
	}	
	
}
