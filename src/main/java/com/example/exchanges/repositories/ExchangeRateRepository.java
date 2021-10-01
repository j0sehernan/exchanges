package com.example.exchanges.repositories;

import com.example.exchanges.entities.Currency;
import com.example.exchanges.entities.ExchangeRate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByOriginCurrencyAndDestinationCurrency(Currency originCurrency, Currency destinationCurrency);
}