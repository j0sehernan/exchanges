package com.example.exchanges.services;

import com.example.exchanges.entities.ExchangeTransaction;
import com.example.exchanges.repositories.ExchangeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeTransactionService {
    @Autowired
    private ExchangeTransactionRepository exchangeTransactionRepository;

    public ExchangeTransaction create(ExchangeTransaction exchangeTransaction) {
        return exchangeTransactionRepository.save(exchangeTransaction);
    }
}
