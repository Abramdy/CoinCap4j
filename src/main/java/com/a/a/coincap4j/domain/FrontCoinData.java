package com.a.a.coincap4j.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FrontCoinData {

	public String cap24hrChange;
	
	@JsonProperty("long")
	public String longName;
	
	public String mktcap;
	
	public String perc;
	
	public String shapeshift;
	
	@JsonProperty("short")
	public String shortName;
	
	public long supply;
	
	public long usdVolume;
	
	/**
	 * Same as usdVolume
	 */
	public long volume;
	
	public String vwapData;
	
	public String vwapDataBTC;

	@Override
	public String toString() {
		return "FrontCoinData [cap24hrChange=" + cap24hrChange + ", longName=" + longName + ", mktcap=" + mktcap
				+ ", perc=" + perc + ", shapeshift=" + shapeshift + ", shortName=" + shortName + ", supply=" + supply
				+ ", usdVolume=" + usdVolume + ", volume=" + volume + ", vwapData=" + vwapData + ", vwapDataBTC="
				+ vwapDataBTC + "]";
	}
	
	
}