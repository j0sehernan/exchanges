package com.example.exchanges.controllers;

import com.example.exchanges.constants.Routes;
import com.example.exchanges.entities.ExchangeTransaction;
import com.example.exchanges.services.ExchangeTransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Routes.EXCHANGES_TRANSACTION, produces = (MediaType.APPLICATION_JSON_VALUE))
public class ExchangeTransactionController {
    @Autowired
    private ExchangeTransactionService exchangeTransactionService;

    @GetMapping
    public List<ExchangeTransaction> list() {
        return exchangeTransactionService.list();
    }
}
