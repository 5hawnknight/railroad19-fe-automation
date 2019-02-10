package com.rr19.library.selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public interface WaitFunctions {
    Function<By,ExpectedCondition<WebElement>> elementToBeClickable = ExpectedConditions::elementToBeClickable;
    Function<By,ExpectedCondition<WebElement>> visibilityOfElementLocated = ExpectedConditions::visibilityOfElementLocated;
}



