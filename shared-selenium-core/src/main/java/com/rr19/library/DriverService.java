package com.rr19.library;

import com.rr19.library.selenium.webdrivers.LocalDriverFactory;
import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;

import static io.vavr.API.*;
import static io.vavr.Predicates.is;

public class DriverService {

    private final Config configuration;

    public WebDriver createInstance(String driver) {
        return Match(driver).of(
                Case($(is("chrome.local")),  d -> LocalDriverFactory.chrome.apply(withLocal(configuration))),
                Case($(is("firefox.local")), d -> LocalDriverFactory.firefox.apply(withLocal(configuration))),
                Case($(is("safari.local")),  d -> LocalDriverFactory.safari.apply(withLocal(configuration)))
        );
    }

    private Config withLocal(Config configuration) {
        return configuration.getConfig("local");
    }

    public DriverService(Config config) {
        configuration = config;
    }
}