package com.todo.shaft.utils;


import com.github.javafaker.Faker;

import java.util.HashMap;

public class UserUtils {

    public static HashMap<String, String> generateRandomUserHashMap() {

        Faker faker = new Faker();

        // Generate fake user data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.internet().password();

        HashMap<String,String> userHashMap = new HashMap<>();
        userHashMap.put("firstName", firstName);
        userHashMap.put("lastName", lastName);
        userHashMap.put("email", userEmail);
        userHashMap.put("password", userPassword);

        return userHashMap;
    }
}
