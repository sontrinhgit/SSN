package com.example.assignmentssnexchange.controller;

import com.example.assignmentssnexchange.model.Query;
import com.example.assignmentssnexchange.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange-amount")
public class ExchangeAmountController {

    @Autowired
    private IExchangeService exchangeService;

    @GetMapping("")
    public ResponseEntity<?> exchange(@RequestParam("from") String from,
                                      @RequestParam("to") String to,
                                      @RequestParam("from_amount") double fromAmount){
        System.out.println(fromAmount);
        return ResponseEntity.ok(exchangeService.exchange(new Query(from, to, fromAmount)));
    }
}
