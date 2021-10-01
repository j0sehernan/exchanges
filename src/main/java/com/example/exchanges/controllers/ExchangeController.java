package com.example.exchanges.controllers;

import com.example.exchanges.constants.Routes;
import com.example.exchanges.requests.ExchangeRequest;
import com.example.exchanges.responses.ExchangeResponse;
import com.example.exchanges.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routes.EXCHANGES, produces = (MediaType.APPLICATION_JSON_VALUE))
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @PostMapping
    public ExchangeResponse create(@RequestBody ExchangeRequest exchangeRequest) {
        return exchangeService.exchange(exchangeRequest);
    }
}
