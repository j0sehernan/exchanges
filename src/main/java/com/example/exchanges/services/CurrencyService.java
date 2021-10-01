package com.example.exchanges.services;

import com.example.exchanges.constants.Messages;
import com.example.exchanges.entities.Currency;
import com.example.exchanges.repositories.CurrencyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> list() {
        return currencyRepository.findAll();
    }

    public Currency get(Long id) {
        return currencyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Messages.CURRENCY_NOT_FOUND));
    }

    public Currency getByCode(String code) {
        return currencyRepository.findByCode(code).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Messages.CURRENCY_NOT_FOUND));
    }

    public Currency create(Currency currency) {
        return currencyRepository.save(currency);
    }

    public Currency update(Long id, Currency currency) {
        Currency currencyToUpdate = get(id);
        currencyToUpdate.setCode(currency.getCode());

        return currencyRepository.save(currencyToUpdate);
    }

    public void delete(Long id) {
        currencyRepository.deleteById(id);
    }
}
