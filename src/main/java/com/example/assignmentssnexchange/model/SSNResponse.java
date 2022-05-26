package com.example.assignmentssnexchange.model;

import lombok.Data;

@Data
public class SSNResponse {
    private boolean ssn_valid;
    private boolean isSuccess;
    private int code;

}
