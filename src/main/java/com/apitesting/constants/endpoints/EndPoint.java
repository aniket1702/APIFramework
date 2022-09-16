package com.apitesting.constants.endpoints;

import com.apitesting.config.ConfigFactory;

public final class EndPoint {
    private EndPoint(){}

    public static final String GET_USER= ConfigFactory.getConfig().baseURI()+"student";
    public static final String ADD_USER= ConfigFactory.getConfig().baseURI()+"student";
    public static final String UPDATE_USER= ConfigFactory.getConfig().baseURI()+"student/";
    public static final String DELETE_USER= ConfigFactory.getConfig().baseURI()+"student/";
}
