package com.exercice.shaft.testcases;

import com.egyptlaptop.api.Apis;
import com.egyptlaptop.api.RegisterAPI;
import com.egyptlaptop.pages.LoginPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest  {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.API api;


    @Story("Classic Login")
    @Description("It will be login by filling the email and the password and navigate to the todo page")
    @Test(description = "Test login functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {
        RegisterAPI registerAPI = new RegisterAPI(api);
        registerAPI.register();

        LoginPage loginPage = new LoginPage(driver);
        boolean isWelcomeDisplayed = loginPage
                .load()
                .login(registerAPI.getEmail(), registerAPI.getPassword())
                .isWelcomeMsgDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        api = new SHAFT.API(Apis.ApisBaseUrl);

    }
}
