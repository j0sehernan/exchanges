package com.example.exchanges.entities;

import com.example.exchanges.constants.Tables;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
@Table(name = Tables.CURRENCIES)
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    public Currency() {
    }

    public Currency(Long id) {
        this.id = id;
    }

    public Currency(String code) {
        this.code = code;
    }
}
