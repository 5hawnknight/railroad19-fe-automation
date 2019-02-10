package com.rr19.library.selenium.waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

public interface CoreExpectedConditions {
    static ExpectedCondition<Boolean> angularProcessingFinish() {
        return driver -> Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
    }
}
