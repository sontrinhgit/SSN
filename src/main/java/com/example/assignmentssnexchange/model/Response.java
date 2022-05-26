package com.example.assignmentssnexchange.model;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Response {
    private Query query;
    private double rate;
    private LocalDate localDate = LocalDate.now();
    private double result;
    private boolean isSuccess;
    private int code;
}
