package com.rr19.pageobjects.cards;

import com.applitools.eyes.selenium.fluent.Target;
import com.rr19.library.BrowserAPI;
import com.rr19.library.EyesHandler;
import com.rr19.library.LoadablePageObject;
import com.rr19.library.selenium.api.Locator;
import com.rr19.models.SearchTerm;
import com.rr19.pageobjects.DashboardPage;

import java.util.function.Supplier;

public interface SearchCard {

    Supplier<SearchCard> po = () -> {
        class Instance implements SearchCard, LoadablePageObject<SearchCard>, BrowserAPI {

            private Locator container = css.apply("[data-tea-search-card]");
            private Locator filterTextBox = css.apply("[data-tea-search-filter]");

            @Override
            public void pageObjectInitializer() {
                toBeVisible.apply(container);
                toBeClickable.apply(filterTextBox);
            }

            @Override
            public SearchCard visualCheckPoint() {
                EyesHandler.eyes().check("Search Card", Target.region(container.element())
                        .layout()
                        .ignoreCaret(true));
                return this;
            }

            @Override
            public SearchCard with(SearchTerm searchTerm) {
                click.andThen(clear)
                        .andThen(typeText.apply(searchTerm.get()))
                        .apply(filterTextBox);
                return this;
            }

            @Override
            public DashboardPage dashboard() {
                return DashboardPage.po.get();
            }
        }
        return new Instance().get();
    };

    SearchCard visualCheckPoint();

    SearchCard with(SearchTerm searchTerm);

    DashboardPage dashboard();
}
