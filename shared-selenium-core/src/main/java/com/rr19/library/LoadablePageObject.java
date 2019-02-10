package com.rr19.library;

@FunctionalInterface
public interface LoadablePageObject<T>
{
    default T get() {
        pageObjectInitializer();
        return (T) this;
    }
    void pageObjectInitializer();
}