package com.rr19.library.selenium.waits;

import com.rr19.library.selenium.api.DriverHandler;
import com.rr19.library.selenium.api.Locator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public interface WebDriverWaitFunctions extends WaitFunctions {
    Function<TimeOut, WebDriverWait> newWebDriverWait = time -> new WebDriverWait(DriverHandler.get(), TimeOut.of(time));
    Function<Function<TimeOut, WebDriverWait>, Function<TimeOut,WebDriverWait>> buildWait = w -> t -> w.apply(t);
    Function<Locator,WebElement> waitForToBeClickable = locator -> newWebDriverWait.apply(TimeOut.DEFAULT).until(elementToBeClickable.apply(locator.selector()));
    Function<Locator,WebElement> waitForToBeVisible = locator -> newWebDriverWait.apply(TimeOut.DEFAULT).until(visibilityOfElementLocated.apply(locator.selector()));
    Runnable waitForAngularToFinishProcessing = () -> newWebDriverWait.apply(TimeOut.DEFAULT).until(CoreExpectedConditions.angularProcessingFinish());
}
