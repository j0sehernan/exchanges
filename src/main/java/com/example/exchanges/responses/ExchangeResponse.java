package com.example.exchanges.responses;

import com.example.exchanges.constants.Fields;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExchangeResponse {
    private double amount;

    @JsonProperty(Fields.ORIGIN_CURRENCY)
    private String originCurrency;

    @JsonProperty(Fields.DESTINATION_CURRENCY)
    private String destinationCurrency;

    @JsonProperty(Fields.EXCHANGE_AMOUNT)
    private double exchangeAmount;

    @JsonProperty(Fields.EXCHANGE_RATE)
    private double exchangeRate;
}
