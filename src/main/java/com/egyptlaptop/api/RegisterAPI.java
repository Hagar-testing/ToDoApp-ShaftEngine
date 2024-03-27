package com.egyptlaptop.api;

import com.egyptlaptop.utils.UserUtils;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static com.egyptlaptop.api.ApiResponseConstants.*;
import static com.egyptlaptop.constants.ApiPaths.REGISTER_API_PATH;
import static io.restassured.RestAssured.given;

public class RegisterAPI {


    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }

    private SHAFT.API api;

    public RegisterAPI(SHAFT.API api) {
        this.api = api;
    }

    public void register() {

        HashMap<String, String> user = UserUtils.generateRandomUserHashMap();

        Response response = api.post(REGISTER_API_PATH)
                .setRequestBody(user)
                .setContentType(ContentType.JSON)
                .setTargetStatusCode(Apis.SUCCESS)
                .performRequest();
        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path(ACCESS_TOKEN);
        userId = response.path(USER_ID);
        firstName = response.path(FIRST_NAME);
        email = user.get("email");
        password = user.get("password");


    }
}
