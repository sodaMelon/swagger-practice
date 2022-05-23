package com.example.test.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    private String name;
    @JsonProperty
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
