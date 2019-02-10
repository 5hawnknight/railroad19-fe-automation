package com.rr19.library.selenium.api;

import java.util.function.Function;

public interface LocatorAPI {

  Function<Locator,Locator> click = locator -> {
    DriverHandler.get().findElement(locator.selector()).click();
    return locator;
  };
  Function<Locator,Locator> clear = locator -> {
    DriverHandler.get().findElement(locator.selector()).clear();
    return locator;
  };
  Function<CharSequence,Function<Locator,Locator>> typeText = value ->
    locator -> {
      DriverHandler.get().findElement(locator.selector()).sendKeys(value);
      return locator;
  };

  Function<Locator,String> getText = locator -> DriverHandler.get().findElement(locator.selector()).getText();
}
