package com.assignment.ExchangeRates.Controller;

import com.assignment.ExchangeRates.Entity.ExchangeEntity;
import com.assignment.ExchangeRates.Service.ExchangeRatesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ExchangeRatesControllerr {

    @Value("${api.key}")
    private String apiKey;

    private static final String ACCESS_KEY = "access_key=";

    private static String url = "http://api.exchangeratesapi.io/v1/latest?";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExchangeRatesService exchangeRatesService;

         @GetMapping("/ExchangeRates")
         public ResponseEntity<ExchangeEntity> getExchangeRatesAndStoreInDB(){
             log.info("In Method getExchangeRatesAndStoreInDB:: ");
             log.info("Invoking RestEnd Point url is: "+url);
             ExchangeEntity exchangeEntity = restTemplate.getForObject(url+ACCESS_KEY+apiKey, ExchangeEntity.class);
             exchangeRatesService.getExchangeRatesAndStoreInDB(exchangeEntity);
             return ResponseEntity.ok(exchangeEntity);
         }

         @GetMapping("/displayExchange/{currency_code}")
         public ResponseEntity<ExchangeEntity> displayExchangeRatesToUserFromDB(@PathVariable(value = "base") String base){
             log.info("In Method displayExchangeRatesToUserFromDB:: ");
             ExchangeEntity exchangeEntity = exchangeRatesService.displayExchangeRatesToUserFromDB(base);
             return ResponseEntity.ok(exchangeEntity);
    }
}
