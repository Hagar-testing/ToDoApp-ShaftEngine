package com.todo.shaft.pages;

import com.todo.shaft.constants.PagePathsConstant;
import com.todo.shaft.utils.ConfigUtils;
import com.shaft.driver.SHAFT;
import com.todo.shaft.constants.LocatorsConstant;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NewToDoPage {

    private final SHAFT.GUI.WebDriver driver;
    private final By newToDo_input = By.cssSelector(LocatorsConstant.NEW_TODO_INPUT);
    private final By submitNewTask_button = By.cssSelector(LocatorsConstant.SUBMIT_NEW_TASK_BUTTON);

    public NewToDoPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public NewToDoPage load() {
        driver.browser().navigateToURL(ConfigUtils.getBaseUrl() + PagePathsConstant.NEW_TODO_PAGE_PATH);
        return this;
    }

    @Step
    public ToDoPage addNewToDo(String todoText) {
        driver.element()
                .type(newToDo_input, todoText)
                .click(submitNewTask_button);

        return new ToDoPage(driver);
    }
}
