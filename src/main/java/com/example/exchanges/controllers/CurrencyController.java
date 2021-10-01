package com.example.exchanges.controllers;

import com.example.exchanges.constants.Routes;
import com.example.exchanges.entities.Currency;
import com.example.exchanges.services.CurrencyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = Routes.CURRENCIES, produces = (MediaType.APPLICATION_JSON_VALUE))
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<Currency> list() {
        return currencyService.list();
    }

    @GetMapping(Routes.ID)
    public Currency get(@PathVariable Long id) {
        return currencyService.get(id);
    }

    @PostMapping
    public Currency create(@RequestBody Currency currency) {
        return currencyService.create(currency);
    }

    @PutMapping(Routes.ID)
    public Currency update(@PathVariable Long id, @RequestBody Currency currency) {
        return currencyService.update(id, currency);
    }

    @DeleteMapping(Routes.ID)
    public void delete(@PathVariable Long id) {
        currencyService.delete(id);
    }
}
