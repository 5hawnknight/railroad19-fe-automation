package com.rr19.tests.visual;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import com.github.javafaker.Faker;
import com.rr19.library.DriverService;
import com.rr19.library.EyesHandler;
import com.rr19.library.selenium.api.DriverHandler;
import com.rr19.library.utils.PropertyReader;
import com.rr19.tests.BaseTest;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Objects;
import java.util.Optional;

public class VisualTest implements BaseTest
{
    private String url = urlConfiguration.getString(PropertyReader.get("env.url"));
    private static BatchInfo batchInfo;

    @BeforeSuite
    public void setBatch() {
        batchInfo = new BatchInfo("project-dashboard").withBatchId(new Faker().idNumber().valid());
    }

    @BeforeMethod
    protected void setDriver(final ITestContext context)
    {
        Eyes eyes = new Eyes();
        eyes.setApiKey(eyesConfiguration.getString("apikey"));
        eyes.setBatch(batchInfo);
        EyesHandler.setEyes(eyes);

        DriverHandler.set(
            EyesHandler.eyes().open(
                new DriverService(driverConfiguration).createInstance(PropertyReader.get("browser")),
                eyesConfiguration.getString("appname"),
                context.getName()
            )
        );

        DriverHandler.get().get(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverHandler.get().quit();
        closeEyes();
    }

    private void closeEyes()
    {
        Optional.ofNullable(EyesHandler.eyes()).filter(object -> Objects.nonNull(object)).ifPresent(e -> e.abortIfNotClosed());
    }
    protected void assertVisualCheckPoints()
    {
        EyesHandler.eyes().close();
    }
}