package com.exercise.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ChangeBalanceRequest {
    private String userUuid;
    private String transactionUuid;
    private int ammount;
}