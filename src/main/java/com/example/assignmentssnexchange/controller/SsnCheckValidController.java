package com.example.assignmentssnexchange.controller;

import com.example.assignmentssnexchange.model.SSNBody;
import com.example.assignmentssnexchange.model.SSNResponse;
import com.example.assignmentssnexchange.service.ISSNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/validate-ssn")
public class SsnCheckValidController {

    @Autowired
    private ISSNService ssnService;

    @PostMapping("")
    public ResponseEntity<?> validateSsn(@RequestBody SSNBody ssnBody){
        if(ssnBody.getSsn() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("SSN require!");
        }
        if(ssnService.isValidSSN(ssnBody.getSsn())){
            SSNResponse ssnResponse = new SSNResponse();
            ssnResponse.setSsn_valid(true);
            ssnResponse.setCode(200);
            ssnResponse.setSuccess(true);
            return ResponseEntity.ok(ssnResponse);
        } else{
            SSNResponse ssnResponse = new SSNResponse();
            ssnResponse.setSsn_valid(false);
            ssnResponse.setCode(200);
            ssnResponse.setSuccess(true);
            return ResponseEntity.ok(ssnResponse);
        }
    }
}
