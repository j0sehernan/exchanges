package com.example.exchanges.repositories;

import com.example.exchanges.entities.ExchangeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeTransactionRepository extends JpaRepository<ExchangeTransaction, Long> {
}