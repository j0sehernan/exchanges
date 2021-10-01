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
@Table(name = Tables.EXCHANGES_TRANSACTION)
public class ExchangeTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

    @JsonProperty(Fields.EXCHANGE_AMOUNT)
    private double exchangeAmount;

    @ManyToOne
    @JoinColumn(name = Fields.EXCHANGE_RATE_ID)
    @JsonProperty(Fields.EXCHANGE_RATE)
    private ExchangeRate exchangeRate;
}
