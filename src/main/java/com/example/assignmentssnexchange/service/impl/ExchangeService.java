package com.example.assignmentssnexchange.service.impl;

import com.example.assignmentssnexchange.model.Query;
import com.example.assignmentssnexchange.model.Response;
import com.example.assignmentssnexchange.service.IExchangeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeService implements IExchangeService {
    private static Map<String, Double> map = new HashMap<>();

    static {
        map.put("EUR_SEK", 10.54);
        map.put("EUR_USD", 1.07);

        map.put("USD_EUR", 0.94);
        map.put("USD_SEK", 9.89);

        map.put("SEK_EUR", 0.095);
        map.put("SEK_USD", 0.10);
    }

    @Override
    public Response exchange(Query query) {
        String key = query.getFrom() + "_" + query.getTo();
        if (!map.containsKey(key)) {
            Response response = new Response();
            response.setQuery(query);
            response.setSuccess(false);
            response.setCode(200);
            return response;
        } else{
            Response response = new Response();
            response.setQuery(query);
            response.setResult(query.getAmount() * map.get(key));
            response.setRate(map.get(key));
            response.setSuccess(true);
            response.setCode(200);
            return response;
        }
    }
}
