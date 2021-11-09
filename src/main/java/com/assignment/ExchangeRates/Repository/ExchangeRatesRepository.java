package com.assignment.ExchangeRates.Repository;


import com.assignment.ExchangeRates.Entity.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRatesRepository extends JpaRepository<ExchangeEntity,String>{
}
