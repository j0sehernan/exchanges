package com.example.exchanges.controllers;

import com.example.exchanges.constants.Routes;
import com.example.exchanges.entities.ExchangeRate;
import com.example.exchanges.services.ExchangeRateService;
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
@RequestMapping(value = Routes.EXCHANGES_RATE, produces = (MediaType.APPLICATION_JSON_VALUE))
public class ExchangeRateController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public List<ExchangeRate> list() {
        return exchangeRateService.list();
    }

    @GetMapping(Routes.ID)
    public ExchangeRate get(@PathVariable Long id) {
        return exchangeRateService.get(id);
    }

    @PostMapping
    public ExchangeRate create(@RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.create(exchangeRate);
    }

    @PutMapping(Routes.ID)
    public ExchangeRate update(@PathVariable Long id, @RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.update(id, exchangeRate);
    }

    @DeleteMapping(Routes.ID)
    public void delete(@PathVariable Long id) {
        exchangeRateService.delete(id);
    }
}
