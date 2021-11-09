package com.assignment.ExchangeRates.Service;

import com.assignment.ExchangeRates.Entity.ExchangeEntity;
import com.assignment.ExchangeRates.Repository.ExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService{

    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Override
    public ExchangeEntity getExchangeRatesAndStoreInDB(ExchangeEntity exchangeEntity) {
        return exchangeRatesRepository.save(exchangeEntity);
    }


    @Override
    public ExchangeEntity displayExchangeRatesToUserFromDB(String base) {
        return exchangeRatesRepository.findById(base).get();
    }

}
