package com.todo.shaft.testcases;

import com.todo.shaft.api.AddNewToDoAPI;
import com.todo.shaft.api.Apis;
import com.todo.shaft.api.RegisterAPI;
import com.todo.shaft.pages.ToDoPage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.todo.shaft.utils.CookieUtils.injectCookiesToBrowser;

@Feature("Todo Feature")
public class ToDoTest  {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.API api;


    @Story("Add Todo")
    @Description("It will be add new to do to the todos list")
    @Test(description = "Should be able to add new to do correctly")
    public void shouldBeAbleToAddNewToDo() {

        RegisterAPI registerAPI = new RegisterAPI(api);
        registerAPI.register();

        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.load();
        injectCookiesToBrowser(driver.getDriver(),registerAPI.getRestAssuredCookies());

        String todoText = "to do";

        String newAddedToDoText = toDoPage
                .load()
                .clickOnAddNewToDoButton()
                .addNewToDo(todoText)
                .getNewAddedToDoText();

        Assert.assertEquals(newAddedToDoText, todoText);
    }

    @Story("Delete Todo")
    @Description("It will be delete the todos list")
    @Test(description = "Should be able to delete todo correctly")
    public void shouldBeAbleToDeleteToDo() {
        String todoText = "to do";

        RegisterAPI registerAPI = new RegisterAPI(api);
        registerAPI.register();

        AddNewToDoAPI addNewToDoAPI = new AddNewToDoAPI(api);
        addNewToDoAPI.addNewToTo(todoText, registerAPI.getAccessToken());


        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.load();
        injectCookiesToBrowser(driver.getDriver(),registerAPI.getRestAssuredCookies());


        boolean isNoToDosPlaceholderTextIsDisplayed = toDoPage
                .load()
                .clickOnDeleteToDoButton()
                .isNoToDosPlaceholderTextIsDisplayed();
        Assert.assertTrue(isNoToDosPlaceholderTextIsDisplayed);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        api = new SHAFT.API(Apis.ApisBaseUrl);

    }


}
