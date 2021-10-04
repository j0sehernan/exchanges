package com.example.exchanges.services;

import com.example.exchanges.entities.ExchangeTransaction;
import com.example.exchanges.repositories.ExchangeTransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeTransactionService {
    @Autowired
    private ExchangeTransactionRepository exchangeTransactionRepository;

    public List<ExchangeTransaction> list() {
        return exchangeTransactionRepository.findAll();
    }

    public ExchangeTransaction create(ExchangeTransaction exchangeTransaction) {
        return exchangeTransactionRepository.save(exchangeTransaction);
    }
}
