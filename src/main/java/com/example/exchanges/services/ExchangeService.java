package com.example.exchanges.services;

import com.example.exchanges.entities.Currency;
import com.example.exchanges.entities.ExchangeRate;
import com.example.exchanges.entities.ExchangeTransaction;
import com.example.exchanges.requests.ExchangeRequest;
import com.example.exchanges.responses.ExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRateService exchangeRateService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private ExchangeTransactionService exchangeTransactionService;

    public ExchangeResponse exchange(ExchangeRequest exchangeRequest) {
        ExchangeResponse exchangeResponse = new ExchangeResponse();
        exchangeResponse.setAmount(exchangeRequest.getAmount());
        exchangeResponse.setOriginCurrency(exchangeRequest.getOriginCurrency());
        exchangeResponse.setDestinationCurrency(exchangeRequest.getDestinationCurrency());

        Currency originCurrency = currencyService.getByCode(exchangeRequest.getOriginCurrency());
        Currency destinationCurrency = currencyService.getByCode(exchangeRequest.getDestinationCurrency());
        ExchangeRate exchangeRate = exchangeRateService.getByOriginCurrencyAndDestinationCurrency(originCurrency, destinationCurrency);

        exchangeResponse.setExchangeRate(exchangeRate.getRate());
        exchangeResponse.setExchangeAmount(exchangeRequest.getAmount() * exchangeRate.getRate());

        exchangeObservable(exchangeResponse, exchangeRate);

        return exchangeResponse;
    }

    public Observable<ExchangeTransaction> exchangeObservable(ExchangeResponse exchangeResponse, ExchangeRate exchangeRate) {
        ExchangeTransaction exchangeTransaction = new ExchangeTransaction();
        exchangeTransaction.setAmount(exchangeResponse.getAmount());
        exchangeTransaction.setExchangeAmount(exchangeResponse.getExchangeAmount());
        exchangeTransaction.setExchangeRate(exchangeRate);
        return Observable.just(exchangeTransactionService.create(exchangeTransaction));
    }
}
