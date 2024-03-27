package com.egyptlaptop.pages;


import com.egyptlaptop.constants.LocatorsConstant;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.egyptlaptop.constants.ConfigConstants.BASE_URL;


public class LoginPage{
    private final SHAFT.GUI.WebDriver driver;

    private final By loginEmail_input = By.id(LocatorsConstant.EMAIL_INPUT);
    private final By loginPassword_input = By.id(LocatorsConstant.PASSWORD_INPUT);
    private final By login_button = By.id(LocatorsConstant.SUBMIT_BUTTON);

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("load login page")
    public LoginPage load() {
        driver.browser().navigateToURL(System.getProperty(BASE_URL));
        return this;
    }

    @Step
    public ToDoPage login(String email, String password) {
        driver.element()
                .type(loginEmail_input, email)
                .type(loginPassword_input, password)
                .click(login_button);

        return new ToDoPage(driver);
    }
}
