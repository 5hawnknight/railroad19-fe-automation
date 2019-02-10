package com.rr19.library.selenium.webdrivers;

import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface LocalDriverFactory {

    Function<String,UnaryOperator<Config>> getBrowserConfiguration = browser -> config -> config.getConfig(browser);
    UnaryOperator<Config> setSystemProperties = config -> {
        System.setProperty(config.getString("driver"), config.getString("path"));
        return config;
    };

    Function<Config,WebDriver> chrome = configuration -> {
        getBrowserConfiguration.apply("chrome").andThen(setSystemProperties).apply(configuration);
        var driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    };
    Function<Config,WebDriver> firefox = configuration -> {
        getBrowserConfiguration.apply("firefox").andThen(setSystemProperties).apply(configuration);
        return new FirefoxDriver();
    };

    Function<Config,WebDriver> safari = configuration -> new SafariDriver();
}