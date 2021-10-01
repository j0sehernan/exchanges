package com.example.exchanges.services;

import com.example.exchanges.constants.Messages;
import com.example.exchanges.entities.Currency;
import com.example.exchanges.entities.ExchangeRate;
import com.example.exchanges.repositories.ExchangeRateRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ExchangeRateService {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public List<ExchangeRate> list() {
        return exchangeRateRepository.findAll();
    }

    public ExchangeRate get(Long id) {
        return exchangeRateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Messages.EXCHANGE_RATE_NOT_FOUND));
    }

    public ExchangeRate getByOriginCurrencyAndDestinationCurrency(Currency originCurrency, Currency destinationCurrency) {
        return exchangeRateRepository.findByOriginCurrencyAndDestinationCurrency(originCurrency, destinationCurrency).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Messages.EXCHANGE_RATE_NOT_FOUND));
    }

    public ExchangeRate create(ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate);
    }

    public ExchangeRate update(Long id, ExchangeRate exchangeRate) {
        ExchangeRate exchangeRateToUpdate = get(id);
        exchangeRateToUpdate.setRate(exchangeRate.getRate());

        return exchangeRateRepository.save(exchangeRateToUpdate);
    }

    public void delete(Long id) {
        exchangeRateRepository.deleteById(id);
    }
}
