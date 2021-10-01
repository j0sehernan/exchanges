package com.example.exchanges.entities;

import com.example.exchanges.constants.Fields;
import com.example.exchanges.constants.Tables;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import lombok.Data;

@Data
@Entity
@Table(name = Tables.EXCHANGES_RATE)
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = Fields.ORIGIN_CURRENCY_ID)
    @JsonProperty(Fields.ORIGIN_CURRENCY)
    private Currency originCurrency;

    @ManyToOne
    @JoinColumn(name = Fields.DESTINATION_CURRENCY_ID)
    @JsonProperty(Fields.DESTINATION_CURRENCY)
    private Currency destinationCurrency;

    private double rate;

    public ExchangeRate() {
    }

    public ExchangeRate(Currency originCurrency, Currency destinationCurrency, double rate) {
        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.rate = rate;
    }
}
