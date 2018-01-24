package com.a.a.coincap4j.domain.history;

import java.time.LocalDate;

import com.a.a.coincap4j.util.Util;

public class HistoricVolume {

	public HistoricVolume(String unixTime, String volume) {
		this.unixTime = Util.localDateFromStr(unixTime);
		this.volume = volume;
	}

	private LocalDate unixTime;
	public String volume;
	
	public LocalDate getUnixTime() {
		return unixTime;
	}

	@Override
	public String toString() {
		return "HistoricVolume [unixTime=" + unixTime + ", volume=" + volume + "]";
	}
	
	
}
