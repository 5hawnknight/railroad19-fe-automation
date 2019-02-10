package com.rr19.library.selenium.api;

import org.openqa.selenium.By;

import java.util.function.Function;

public interface Find {
    Function<Locator,Function<String,Locator>> chainCss = l -> s -> new ChainedBuilder(By.cssSelector(s),l);
    Function<String,Locator> css = s -> new Builder(By.cssSelector(s));
    Function<Locator,Function<String,Locator>> chainXpath = l -> s -> new ChainedBuilder(By.xpath(s),l);
    Function<String,Locator> xpath = s -> new Builder(By.xpath(s));
}