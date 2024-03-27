package com.egyptlaptop.pages;

import com.egyptlaptop.constants.PagePathsConstant;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.egyptlaptop.constants.ConfigConstants.BASE_URL;
import static com.egyptlaptop.constants.LocatorsConstant.NEW_TODO_INPUT;
import static com.egyptlaptop.constants.LocatorsConstant.SUBMIT_NEW_TASK_BUTTON;

public class NewToDoPage {

    private final SHAFT.GUI.WebDriver driver;
    private final By newToDo_input = By.cssSelector(NEW_TODO_INPUT);
    private final By submitNewTask_button = By.cssSelector(SUBMIT_NEW_TASK_BUTTON);

    public NewToDoPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public NewToDoPage load() {
        driver.browser().navigateToURL(System.getProperty(BASE_URL) + PagePathsConstant.NEW_TODO_PAGE_PATH);
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
