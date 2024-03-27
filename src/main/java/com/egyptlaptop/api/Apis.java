package com.egyptlaptop.api;

import com.egyptlaptop.utils.ConfigUtils;
import com.shaft.driver.SHAFT;

import static com.egyptlaptop.constants.ConfigConstants.BASE_URL;

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
