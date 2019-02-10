package com.rr19.tests.functional;

import com.rr19.assertions.Assertions;
import com.rr19.library.DriverService;
import com.rr19.library.selenium.api.DriverHandler;
import com.rr19.library.utils.PropertyReader;
import com.rr19.tests.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class FunctionalTest implements BaseTest
{
    private String url = urlConfiguration.getString(PropertyReader.get("env.url"));

    @BeforeMethod
    protected void setDriver(final ITestContext context)
    {
        DriverHandler.set(new DriverService(driverConfiguration).createInstance(PropertyReader.get("browser")));
        DriverHandler.get().get(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverHandler.get().quit();
    }

    public Assertions assertions() {
        return new Assertions();
    }
}