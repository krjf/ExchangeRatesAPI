package com.assignment.ExchangeRates.Service;


import com.assignment.ExchangeRates.Entity.ExchangeEntity;
import org.springframework.stereotype.Service;

@Service
public interface ExchangeRatesService {
    ExchangeEntity getExchangeRatesAndStoreInDB(ExchangeEntity exchangeEntity);

    ExchangeEntity displayExchangeRatesToUserFromDB(String base);


}
