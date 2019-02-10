package com.rr19.library.selenium.api;

import org.openqa.selenium.WebDriver;

public class DriverHandler {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver get() { return driver.get(); }

    public static void set(WebDriver _driver) { driver.set(_driver); }
}




