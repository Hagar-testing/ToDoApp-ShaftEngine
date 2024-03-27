package com.egyptlaptop.api;


import com.egyptlaptop.objects.Task;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddNewToDoAPI {

    private SHAFT.API api;

    public AddNewToDoAPI(SHAFT.API api) {
        this.api = api;
    }

    public void addNewToTo(String toDoContent,String token) {

        Task body = new Task(toDoContent,false);
//
//        Response response =
//                given()
//                        .baseUri(ConfigUtils.getBaseUrl())
//                        .header("Content-Type", "application/json")
//                        .body(body)
//                        .auth().oauth2(token)
//                        .log().all()
//                        .when()
//                        .post(ADD_NEW_TODO_API)
//                        .then()
//                        .log().all()
//                        .extract().response();
//
//        if(response.statusCode() != 201){
//            throw new RuntimeException("Something went wrong in adding todo");
//        }

        api.post("")
                .setRequestBody(body)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(Apis.SUCCESS)
                .perform();

    }
}
