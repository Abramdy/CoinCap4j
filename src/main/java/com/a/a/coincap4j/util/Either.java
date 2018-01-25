package com.a.a.coincap4j.util;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Either<L, R> {
	public static <L, R> Either<L, R> left(L value) {
		return new Either<L, R>() {
			@Override
			public <T> T map(Function<? super L, ? extends T> lFunc, Function<? super R, ? extends T> rFunc) {
				return lFunc.apply(value);
			}
			
			@Override
			public L getLeft() {
				return value;
			}
			
			@Override
			public L getLeft(L valueIfNotPresent) {
				return value;
			}
			
			@Override
			public boolean isLeftPresent() {
				return true;
			}
			
			@Override
			public R getRight() {
				return null;
			}
			
			@Override
			public R getRight(R valueIfNotPresent) {
				return valueIfNotPresent;
			}
			
			@Override
			public boolean isRightPresent() {
				return false;
			}
		};
	}

	public static <L, R> Either<L, R> right(R value) {
		return new Either<L, R>() {
			@Override
			public <T> T map(Function<? super L, ? extends T> lFunc, Function<? super R, ? extends T> rFunc) {
				return rFunc.apply(value);
			}
			
			@Override
			public L getLeft() {
				return null;
			}
			
			@Override
			public L getLeft(L valueIfNotPresent) {
				return valueIfNotPresent;
			}
			
			@Override
			public boolean isLeftPresent() {
				return false;
			}
			
			@Override
			public R getRight() {
				return value;
			}
			
			@Override
			public R getRight(R valueIfNotPresent) {
				return value;
			}
			
			@Override
			public boolean isRightPresent() {
				return true;
			}

		};
	}

	private Either() {
	}

	public abstract <T> T map(Function<? super L, ? extends T> lFunc, Function<? super R, ? extends T> rFunc);
	
	/**
	 * Checks if there is a left value.
	 * @return
	 */
	public abstract boolean isLeftPresent();
	/**
	 * Returns the left value if present or null if not present.
	 * @return
	 */
	public abstract L getLeft();
	/**
	 * Returns the left value if present or passed value if not present.
	 * @param valueIfNotPresent
	 * @return
	 */
	public abstract L getLeft(L valueIfNotPresent);
	
	/**
	 * Checks if there is a left value.
	 * @return
	 */
	public abstract boolean isRightPresent();
	/**
	 * Returns the right value if present or null if not present.
	 * @return
	 */
	public abstract R getRight();
	/**
	 * Returns the right value if present or passed value if not present.
	 * @param valueIfNotPresent
	 * @return
	 */
	public abstract R getRight(R valueIfNotPresent);

	public <T> Either<T, R> mapLeft(Function<? super L, ? extends T> lFunc) {
		return this.<Either<T, R>>map(t -> left(lFunc.apply(t)), t -> (Either<T, R>) this);
	}

	public <T> Either<L, T> mapRight(Function<? super R, ? extends T> lFunc) {
		return this.<Either<L, T>>map(t -> (Either<L, T>) this, t -> right(lFunc.apply(t)));
	}

	public void apply(Consumer<? super L> lFunc, Consumer<? super R> rFunc) {
		map(consume(lFunc), consume(rFunc));
	}

	private <T> Function<T, Void> consume(Consumer<T> c) {
		return t -> {
			c.accept(t);
			return null;
		};
	}
}
