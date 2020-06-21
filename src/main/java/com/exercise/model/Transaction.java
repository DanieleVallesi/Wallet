package com.exercise.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String uuid;

    private Date date;

    private int ammount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    User user;

    public Transaction(String uuid, Date date, int ammount, User user) {
        this.uuid = uuid;
        this.date = date;
        this.ammount = ammount;
        this.user = user;
    }
}
