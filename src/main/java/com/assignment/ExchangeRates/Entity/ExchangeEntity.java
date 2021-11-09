package com.assignment.ExchangeRates.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
public class ExchangeEntity {

    private boolean success;
    private Long timestamp;
    @Id
    private String base;
    private String date;

    @ElementCollection
    @CollectionTable(name = "rates_mapping",
            joinColumns = {@JoinColumn(name = "rates_id", referencedColumnName = "base")})
    @MapKeyColumn(name = "currency_codes")
    @Column(name = "price")
    private Map<String,Double> rates = new HashMap<>();
}
