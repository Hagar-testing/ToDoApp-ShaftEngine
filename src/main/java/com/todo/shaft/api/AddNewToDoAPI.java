package com.todo.shaft.api;


import com.todo.shaft.models.Task;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static com.todo.shaft.constants.ApiPaths.TASKS_API_PATH;
import static io.restassured.RestAssured.given;

public class AddNewToDoAPI {

    private SHAFT.API api;

    public AddNewToDoAPI(SHAFT.API api) {
        this.api = api;
    }

    public void addNewToTo(String toDoContent,String token) {

        HashMap<String,String> tasksHashMap = new HashMap<>();
        tasksHashMap.put("item", toDoContent);
        tasksHashMap.put("isCompleted", "false");

        api.post(TASKS_API_PATH)
                .addHeader("Authorization","Bearer " + token)
                .setRequestBody(tasksHashMap)
                .setContentType(ContentType.JSON)
                .setTargetStatusCode(Apis.SUCCESS)
                .perform();

    }
}
