package com.example.exchanges.setup;

import com.example.exchanges.entities.Currency;
import com.example.exchanges.entities.ExchangeRate;
import com.example.exchanges.repositories.CurrencyRepository;
import com.example.exchanges.repositories.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LoadData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Currencies
        Currency currencyPEN = new Currency("PEN");
        Currency currencyUSD = new Currency("USD");
        Currency currencyJPY = new Currency("JPY");

        currencyRepository.save(currencyPEN);
        currencyRepository.save(currencyUSD);
        currencyRepository.save(currencyJPY);
        // Exchanges
        exchangeRateRepository.save(new ExchangeRate(currencyPEN, currencyUSD, 0.24));
        exchangeRateRepository.save(new ExchangeRate(currencyUSD, currencyPEN, 4.13));
        exchangeRateRepository.save(new ExchangeRate(currencyJPY, currencyPEN, 0.037));
        exchangeRateRepository.save(new ExchangeRate(currencyPEN, currencyJPY, 26.92));
        exchangeRateRepository.save(new ExchangeRate(currencyUSD, currencyJPY, 111.25));
        exchangeRateRepository.save(new ExchangeRate(currencyUSD, currencyJPY, 0.0090));
    }
}
