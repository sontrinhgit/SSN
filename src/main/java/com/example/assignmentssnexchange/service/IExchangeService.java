package com.example.assignmentssnexchange.service;

import com.example.assignmentssnexchange.model.Query;
import com.example.assignmentssnexchange.model.Response;

public interface IExchangeService {
    Response exchange(Query query);
}
