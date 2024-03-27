package com.egyptlaptop.utils;

import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();
        for (Cookie cookie: restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;
    }

    @Step
    public static void injectCookiesToBrowser(WebDriver driver, List<Cookie> restAssuredCookies){

        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for (org.openqa.selenium.Cookie seleniumCookie : seleniumCookies){
            driver.manage().addCookie(seleniumCookie);
        }
    }
}
