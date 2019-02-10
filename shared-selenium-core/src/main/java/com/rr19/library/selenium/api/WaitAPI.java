package com.rr19.library.selenium.api;

import com.rr19.library.selenium.waits.WebDriverWaitFunctions;

import java.util.function.Function;

public interface WaitAPI {

    Function<Locator,Locator> toBeClickable = locator -> { WebDriverWaitFunctions.waitForToBeClickable.apply(locator); return locator; };
    Function<Locator,Locator> toBeVisible = locator -> { WebDriverWaitFunctions.waitForToBeVisible.apply(locator); return locator; };
}
