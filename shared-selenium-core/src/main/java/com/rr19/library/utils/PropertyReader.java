package com.rr19.library.utils;

public interface PropertyReader {
    static String get(String property) {
        return System.getProperty(property);
    }
}