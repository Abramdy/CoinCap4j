package com.a.a.coincap4j.util;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
