package com.apitesting.config;

import org.aeonbits.owner.ConfigCache;


public final class ConfigFactory {
    private  ConfigFactory(){

    }
    public static ConfigProperties getConfig(){
        return ConfigCache.getOrCreate(ConfigProperties.class);
    }
}
