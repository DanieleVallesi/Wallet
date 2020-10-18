package com.exercise.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CreateUserRequest {
    private String userUuid;
    private String name;

    @Min(0) // This will get checked with @Value in the controller
    private int balance;
}