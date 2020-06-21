package com.exercise.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String uuid;

    private String name;

    private int balance;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactionList;

    //constructor
    public User(String uuid, String name, int balance) {
        this.uuid = uuid;
        this.name = name;
        this.balance = balance;
        this.transactionList = new ArrayList<Transaction>();
    }

}
