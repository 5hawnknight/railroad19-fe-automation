package com.rr19.tests;

import com.rr19.library.configuration.ConfigurationFactory;
import com.rr19.pageobjects.DashboardPage;

public interface BaseTest extends ConfigurationFactory
{
    default DashboardPage dashboard() {
        return DashboardPage.po.get();
    }
}