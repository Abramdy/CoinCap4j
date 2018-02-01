

       _____      _        _____           _  _       _ 
      / ____|    (_)      / ____|         | || |     | |
     | |     ___  _ _ __ | |     __ _ _ __| || |_    | |
     | |    / _ \| | '_ \| |    / _` | '_ \__   _|   | |
     | |___| (_) | | | | | |___| (_| | |_) | | || |__| |
      \_____\___/|_|_| |_|\_____\__,_| .__/  |_| \____/ 
                                 | |                
                                 |_|                

                                                                     
---------------------

## CoinCap4J is a Java wrapper around the api provided by https://github.com/CoinCapDev/CoinCap.io

To use Coin4J simply call:

```java
    CoinCap4j cc4j = CoinCap4j.instance();
```

Each method returning coincap data return an `Either`object, which has the following interface:

```java
	public <T> T map(Function<? super L, ? extends T> lFunc, Function<? super R, ? extends T> rFunc);
	
	/**
	 * Checks if there is a left value.
	 * @return
	 */
	public boolean isLeftPresent();
	/**
	 * Returns the left value if present or null if not present.
	 * @return
	 */
	public L getLeft();
	/**
	 * Returns the left value if present or passed value if not present.
	 * @param valueIfNotPresent
	 * @return
	 */
	public L getLeft(L valueIfNotPresent);
	
	/**
	 * Checks if there is a left value.
	 * @return
	 */
	public boolean isRightPresent();
	/**
	 * Returns the right value if present or null if not present.
	 * @return
	 */
	public R getRight();
	/**
	 * Returns the right value if present or passed value if not present.
	 * @param valueIfNotPresent
	 * @return
	 */
	public R getRight(R valueIfNotPresent);

	public <T> Either<T, R> mapLeft(Function<? super L, ? extends T> lFunc);

	public <T> Either<L, T> mapRight(Function<? super R, ? extends T> lFunc);

	public void apply(Consumer<? super L> lFunc, Consumer<? super R> rFunc);
```

* Following is a list of api endpoint and their corresponding method calls:

```java
        // http://coincap.io/coins
    public Either<List<String>, Exception> getCoinsListShort();

        // http://coincap.io/map
    public Either<List<CoinMap>, Exception> getCoinsMap();

        // http://coincap.io/front
    public Either<List<FrontCoinData>, Exception> getFrontCoinData();

       // http://coincap.io/global
    public Either<GlobalData, Exception> getGlobalData();
      
      // http://coincap.io/page/:coin
    public Either<Coin, Exception> getCoin(String symbol);

      // for getting multiple coins
    public List<Either<Coin, Exception>> getCoins(List<String> coins);

    // for getting the history of a coin http://coincap.io/history/:coin you use

    HistoryBuilder hb = cc4j.history(coin);
    // for the period you basically call:
    hb.day()
    hb.week()
    hb.month()
    hb.quaterly()
    hb.halfYear()
    hb.year()

    // for accessing socket data you can use one of the following methods on the CoinCap4J instance
    public void trades(Consumer<JSONObject> dataConsumer) throws URISyntaxException
    public void tradesData(Consumer<Either<TradeData, Exception>> dataConsumer) throws URISyntaxException
```