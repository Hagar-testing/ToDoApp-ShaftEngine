package com.todo.shaft.api;

import com.todo.shaft.utils.ConfigUtils;
import com.shaft.driver.SHAFT;

public class Apis {
    private SHAFT.API api;

    public Apis(SHAFT.API api) {
        this.api = api;
    }

    // Base URL
    public static String ApisBaseUrl = ConfigUtils.getBaseUrl();

    // Status Codes
    public static final int SUCCESS = 201;



}
