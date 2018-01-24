package com.a.a.coincap4j.domain;

import org.joda.money.Money;

import com.a.a.coincap4j.util.Util;

public class GlobalData {
	
	public String altCap;
	
	public long bitnodesCount;
	
	public String btcCap;
	
	public String btcPrice;
	
	/**
	 * The percentage of bitcoin dominance.
	 */
	public double dom;
	
	public String totalCap;
	
	public String volumeAlt;
	
	public String volumeBtc;
	
	public String volumeTotal;
	
	public Money getBtcPriceUsd() {
		return Util.stringToUsd(btcPrice);
	}

	@Override
	public String toString() {
		return "GlobalData [altCap=" + altCap + ", bitnodesCount=" + bitnodesCount + ", btcCap=" + btcCap
				+ ", btcPrice=" + btcPrice + ", dom=" + dom + ", totalCap=" + totalCap + ", volumeAlt=" + volumeAlt
				+ ", volumeBtc=" + volumeBtc + ", volumeTotal=" + volumeTotal + "]";
	}
	
	

}