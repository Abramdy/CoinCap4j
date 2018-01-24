package com.a.a.coincap4j.domain.history;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InternalHistoryRepresentation {
	
	@JsonProperty("market_cap")
	public List<List<String>> marketCap;
	
	public List<List<String>> price;
	
	public List<List<String>> volume;

	@Override
	public String toString() {
		return "InternalHistoryRepresentation [marketCap=" + marketCap + ", price=" + price + ", volume=" + volume
				+ "]";
	}
	
}

//{
//    "market_cap": [
//        [
//            1504664370000,  // unix time (milliseconds)
//            74300994770     // market cap
//        ],
//    ],
//    "price" : [
//        [
//            1504750775000,
//            4507.45 
//        ],
//    ],
//    "volume": [
//        [
//            1504750775000,  
//            2095800000   
//        ],
//    ]
//}
