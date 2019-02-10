package com.rr19.pageobjects;

import com.applitools.eyes.selenium.fluent.Target;
import com.rr19.library.BrowserAPI;
import com.rr19.library.EyesHandler;
import com.rr19.library.LoadablePageObject;
import com.rr19.library.selenium.api.Locator;
import com.rr19.models.Title;
import com.rr19.pageobjects.cards.RecordCard;
import com.rr19.pageobjects.cards.SearchCard;
import com.rr19.pageobjects.cards.StatisticsCard;

import java.util.function.Function;
import java.util.function.Supplier;

public interface DashboardPage {

    Supplier<DashboardPage> po = () -> {
        class Instance implements DashboardPage, LoadablePageObject<DashboardPage>, BrowserAPI {

            private Locator container = css.apply("[data-tea-dashboard]");
            private Function<String,Locator> findRecordCard = value ->
                    css.apply(String.format("[data-tea-record='%s']",value));

            @Override
            public void pageObjectInitializer() {
                toBeVisible.apply(container);
            }
            @Override
            public DashboardPage visualCheckPoint() {
                EyesHandler.eyes().check("Dashboard Page", Target.window()
                        .layout()
                        .ignoreCaret(true));
                return this;
            }

            @Override
            public StatisticsCard statistics() {
                return StatisticsCard.po.get();
            }

            @Override
            public SearchCard search() {
                return SearchCard.po.get();
            }

            @Override
            public RecordCard findRecord(Title record) {
                return RecordCard.po.apply(findRecordCard.apply(record.get()));
            }
        }
        return new Instance().get();
    };
    DashboardPage visualCheckPoint();
    StatisticsCard statistics();
    SearchCard search();
    RecordCard findRecord(Title record);
}
