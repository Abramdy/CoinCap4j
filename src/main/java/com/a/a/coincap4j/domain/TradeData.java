package com.a.a.coincap4j.domain;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TradeData {

	@JsonProperty("coin")
	public String coinName;
	
	@JsonProperty("exchange_id")
	public String exchangeId;
	
	@JsonProperty("market_id")
	public String marketId;
	
	public Number cap24hrChange;
	
	public String longName;
	
	public Number marketCap;
	
	public Number percentage;
	
	public Number priceInUsd;
	
	public boolean shapeshift;
	
	public Number supply;
	
	public Number usdVolume;
	
	public Number volume;
	
	public Number vwapData;
	
	public Number vwapDataBTC;
	
    @JsonProperty("msg")
    private void unpackNested(Map<String,Object> msg) {
        this.cap24hrChange = (Number) msg.get("cap24hrChange");
        this.longName = (String) msg.get("long");
        this.marketCap = (Number) msg.get("mktcap");
        this.percentage = (Number) msg.get("perc");
        this.priceInUsd = (Number) msg.get("price");
        this.shapeshift = (boolean) msg.get("shapeshift");
        this.supply = (Number) msg.get("supply");
        this.usdVolume = (Number) msg.get("usdVolume");
        this.volume = (Number) msg.get("volume");
        this.vwapData = (Number) msg.get("vwapData");
        this.vwapDataBTC = (Number) msg.get("vwapDataBTC");        
    }

	@Override
	public String toString() {
		return "TradeData [coinName=" + coinName + ", exchangeId=" + exchangeId + ", marketId=" + marketId
				+ ", cap24hrChange=" + cap24hrChange + ", longName=" + longName + ", marketCap=" + marketCap
				+ ", percentage=" + percentage + ", priceInUsd=" + priceInUsd + ", shapeshift=" + shapeshift
				+ ", supply=" + supply + ", usdVolume=" + usdVolume + ", volume=" + volume + ", vwapData=" + vwapData
				+ ", vwapDataBTC=" + vwapDataBTC + "]";
	}
    
}
