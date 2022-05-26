package com.example.assignmentssnexchange.model;

import lombok.Data;

@Data
public class Query {
    private String from;
    private String to;
    private double amount;

    public Query(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}
