package com.exercise.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Getter @AllArgsConstructor
public class CreateUserRequest {

    @NotEmpty(message = "userUuid can not be empty")
    private String userUuid;

    @NotEmpty(message = "name can not be empty")
    private String name;

    @Positive // This will get checked with @Value in the controller
    private int balance;
}