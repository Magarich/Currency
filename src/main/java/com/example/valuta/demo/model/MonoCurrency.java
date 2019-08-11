package com.example.valuta.demo.model;

import lombok.Data;

@Data
public class MonoCurrency {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private Float rateBuy;
    private Float rateSale;


}
