package com.exercise.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @AllArgsConstructor
public class ChangeBalanceRequest {

    @NotEmpty(message = "userUuid can not be empty")
    private String userUuid;

    @NotBlank
    @NotEmpty(message = "userUuid can not be empty")
    private String transactionUuid;

    private int ammount;
}
