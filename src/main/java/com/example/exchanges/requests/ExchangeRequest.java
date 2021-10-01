package com.example.exchanges.requests;

import com.example.exchanges.constants.Fields;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExchangeRequest {
    private double amount;

    @JsonProperty(Fields.ORIGIN_CURRENCY)
    private String originCurrency;

    @JsonProperty(Fields.DESTINATION_CURRENCY)
    private String destinationCurrency;
}
