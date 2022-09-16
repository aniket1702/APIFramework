package com.apitesting.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "system:env", "file:${user.dir}/src/main/resources/config.properties" })
public interface ConfigProperties extends Config {

    @Key("baseURI")
    String baseURI();

    @Key("environment")
    String environment();

    @Key("overrideReport")
    String overrideReport();
}
