package com.todo.shaft.pages;


import com.todo.shaft.constants.LocatorsConstant;
import com.todo.shaft.utils.ConfigUtils;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


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
        driver.browser().navigateToURL(ConfigUtils.getBaseUrl());
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
