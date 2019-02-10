package com.rr19.pageobjects.cards;

import com.applitools.eyes.selenium.fluent.Target;
import com.rr19.library.BrowserAPI;
import com.rr19.library.EyesHandler;
import com.rr19.library.LoadablePageObject;
import com.rr19.library.selenium.api.Locator;

import java.util.function.Supplier;

public interface StatisticsCard {

    Supplier<StatisticsCard> po = () -> {
        class Instance implements StatisticsCard, LoadablePageObject<StatisticsCard>, BrowserAPI {

            private Locator container = css.apply("[data-tea-statistics-card]");


            @Override
            public void pageObjectInitializer() {
                toBeVisible.apply(container);
            }
            @Override
            public StatisticsCard visualCheckPoint() {
                EyesHandler.eyes().check("Statistics Card", Target.region(container.element())
                        .layout()
                        .ignoreCaret(true));
                return this;
            }
        }
        return new Instance().get();
    };

    StatisticsCard visualCheckPoint();
}
