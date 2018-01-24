package com.a.a.coincap4j.domain;

import java.util.List;

public class CoinMap {
	
	public String name;
	
	public String symbol;
	
	public List<String> aliases;

	@Override
	public String toString() {
		return "CoinMap [name=" + name + ", symbol=" + symbol + ", aliases=" + aliases + "]";
	}

}
