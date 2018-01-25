package com.a.a.coincap4j.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import org.joda.money.Money;

public class Util {
	
	public static final String DEFAULT_CURRENCY = "USD";
	
	public static final class CoinCapCurrency {
		public static final String DEFAULT_CURRENCY = "USD";
		public static final String USD = "USD";
		public static final String EUR = "EUR";
		public static final String Z_CASH = "ZEC";
		public static final String LITECOIN = "LTC";
		public static final String BITCOIN = "BTC";
		public static final String ETHEREUM = "ETH";
	}
	
	private static final UnaryOperator<String> FMT_DEFAULT_CURRENCY = s -> DEFAULT_CURRENCY + " " + s;
	
	private static final BinaryOperator<String> FMT_FOR_CURRENCY = (price, currency) -> currency + " " + price;
	
	public static Money stringToCurrency(String price, String currency) {
		return Money.parse(FMT_FOR_CURRENCY.apply(price, currency));
	}
	
	public static Money stringToUsd(String usdValue) {
		return Money.parse(FMT_DEFAULT_CURRENCY.apply(usdValue));
	}
	
	public static LocalDate localDateFromStr(String unixTime) {
		return Instant.ofEpochMilli(Long.parseLong(unixTime)).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static <T> Either<T, Exception> wrapInEither(ThrowingSupplier<T> supplier) {
		try {
			T data = supplier.get();
			return Either.left(data);
		} catch (Exception e) {
			return Either.right(e);
		}
	}
}
