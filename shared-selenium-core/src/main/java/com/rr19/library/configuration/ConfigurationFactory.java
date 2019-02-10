package com.rr19.library.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigurationFactory {
    Config configuration = ConfigFactory.load();
    Config driverConfiguration = configuration.getConfig("drivers");
    Config urlConfiguration =  configuration.getConfig("urls");
    Config eyesConfiguration = configuration.getConfig("eyes");
}