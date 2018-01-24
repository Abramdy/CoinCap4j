
package com.a.a.coincap4j.domain;

import org.joda.money.Money;

import com.a.a.coincap4j.util.Util;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Coin {
	
	public String altCap;
	public long bitnodesCount;
	
	public String btcCap;
	
	@JsonProperty("dom")
	public String btcDom;
	
	public String totalCap;
	
	public String volumeAlt;
	
	public String volumeBtc;
	
	public String volumeTotal;
	
	public String id;
	
	@JsonProperty("_id")
	public String alternativeId;
	
	public String cap24hrChange;
	
	@JsonProperty("display_name")
	public String displayName;
	
	public String status;
	
	public long supply;
	
	public long volume;
	
	public String vwap_h24;
	
	public String price_btc;
	
	/**
	 * Ethereum price.
	 */
	public String price_eth;
	
	public String price_eur;
	
	public String price_usd;
	
	/**
	 * Litecoin price.
	 */
	public String price_ltc;
	
	/**
	 * Zcash price.
	 */
	public String price_zec;
	
	public String market_cap;
	
	public String type;
	
	public String price;
	
	public Money getPriceInBtc() {
		return Util.stringToCurrency(price_btc, Util.CoinCapCurrency.BITCOIN);
	}
	
	public Money getPriceInEth() {
		return Util.stringToCurrency(price_eth, Util.CoinCapCurrency.ETHEREUM);
	}
	
	public Money getPriceInUsd() {
		return Util.stringToCurrency(price_usd, Util.CoinCapCurrency.USD);
	}
	
	public Money getPriceInEur() {
		return Util.stringToCurrency(price_eur, Util.CoinCapCurrency.EUR);
	}
	
	public Money getPriceInLtc() {
		return Util.stringToCurrency(price_ltc, Util.CoinCapCurrency.LITECOIN);
	}
	
	public Money getPriceInZec() {
		return Util.stringToCurrency(price_zec, Util.CoinCapCurrency.Z_CASH);
	}

	@Override
	public String toString() {
		return "Coin [altCap=" + altCap + ", bitnodesCount=" + bitnodesCount + ", btcCap=" + btcCap + ", btcDom="
				+ btcDom + ", totalCap=" + totalCap + ", volumeAlt=" + volumeAlt + ", volumeBtc=" + volumeBtc
				+ ", volumeTotal=" + volumeTotal + ", id=" + id + ", alternativeId=" + alternativeId
				+ ", cap24hrChange=" + cap24hrChange + ", displayName=" + displayName + ", status=" + status
				+ ", supply=" + supply + ", volume=" + volume + ", vwap_h24=" + vwap_h24 + ", price_btc=" + price_btc
				+ ", price_eth=" + price_eth + ", price_eur=" + price_eur + ", price_usd=" + price_usd + ", price_ltc="
				+ price_ltc + ", price_zec=" + price_zec + ", market_cap=" + market_cap + ", type=" + type + ", price="
				+ price + "]";
	}
	
	
	
}