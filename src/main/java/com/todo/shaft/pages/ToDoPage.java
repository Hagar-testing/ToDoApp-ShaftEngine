package com.todo.shaft.pages;

import com.todo.shaft.constants.LocatorsConstant;
import com.todo.shaft.constants.PagePathsConstant;
import com.todo.shaft.utils.ConfigUtils;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class ToDoPage  {

    private final SHAFT.GUI.WebDriver driver;
    private final By addNewToDo_button = By.cssSelector(LocatorsConstant.ADD_NEW_TODO_BUTTON);
    private final By toDo_text = By.cssSelector(LocatorsConstant.TODO_TEXT_ELEMENT);
    private final By welcomeMsg_text = By.cssSelector(LocatorsConstant.WELCOME_MSG);
    private final By deleteToDo_button = By.cssSelector(LocatorsConstant.DELETE_TODO_BUTTON);
    private final By noDoTosPlaceholder_text = By.cssSelector(LocatorsConstant.NO_TODOS_PLACEHOLDER_TEXT);

    public ToDoPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;

    }

    @Step
    public ToDoPage load() {
        driver.browser().navigateToURL(ConfigUtils.getBaseUrl() + PagePathsConstant.TODO_PAGE_PATH);
        return this;
    }

    @Step
    public NewToDoPage clickOnAddNewToDoButton() {
        driver.element().click(addNewToDo_button);
        return new NewToDoPage(driver);
    }

    @Step
    public String getNewAddedToDoText() {
        return driver.element().getText(toDo_text);
    }

    @Step
    public Boolean isWelcomeMsgDisplayed() {
        return driver.element().isElementDisplayed(welcomeMsg_text);
    }

    @Step
    public ToDoPage clickOnDeleteToDoButton() {
        driver.element().click(deleteToDo_button);
        return this;
    }

    @Step
    public boolean isNoToDosPlaceholderTextIsDisplayed() {
        return driver.element().isElementDisplayed(noDoTosPlaceholder_text);
    }

}
