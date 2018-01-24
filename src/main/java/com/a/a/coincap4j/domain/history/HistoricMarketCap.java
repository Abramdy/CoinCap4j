package com.a.a.coincap4j.domain.history;

import java.time.LocalDate;

import com.a.a.coincap4j.util.Util;

public class HistoricMarketCap {

	public HistoricMarketCap(String unixTime, String marketCap) {
		this.unixTime = Util.localDateFromStr(unixTime);
		this.marketCap = marketCap;
	}

	private LocalDate unixTime;
	public String marketCap;
	
	public LocalDate getUnixTime() {
		return unixTime;
	}

	@Override
	public String toString() {
		return "HistoricMarketCap [unixTime=" + unixTime + ", marketCap=" + marketCap + "]";
	}

}
