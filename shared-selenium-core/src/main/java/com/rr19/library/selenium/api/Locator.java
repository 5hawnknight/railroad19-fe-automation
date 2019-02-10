package com.rr19.library.selenium.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

public interface Locator {

    By selector();
    default WebElement element() {
        return DriverHandler.get().findElement(selector());
    }
    default List<WebElement> elements() {
        return DriverHandler.get().findElements(selector());
    }
}

class Builder implements Locator {

    private By by;

    public Builder(By by) {
        this.by = by;
    }

    @Override
    public By selector() {
        return this.by;
    }
}

class ChainedBuilder implements Locator {

    private By by;

    public ChainedBuilder(By by, Locator locator) {
        this.by = new ByChained(locator.selector(), by);
    }

    @Override
    public By selector() {
        return this.by;
    }
}