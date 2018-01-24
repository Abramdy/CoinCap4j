package com.a.a.coincap4j.domain.history;

import java.time.LocalDate;

import com.a.a.coincap4j.util.Util;

public class HistoricPrice {

	public HistoricPrice(String unixTime, String price) {
		this.unixTime = Util.localDateFromStr(unixTime);
		this.price = price;
	}

	private LocalDate unixTime;
	public String price;
	
	public LocalDate getUnixTime() {
		return unixTime;
	}

	@Override
	public String toString() {
		return "HistoricPrice [unixTime=" + unixTime + ", price=" + price + "]";
	}
	
}
