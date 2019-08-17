package com.example.valuta.demo.service;

import com.example.valuta.demo.constant.CurrencyConstant;
import com.example.valuta.demo.model.bank.BankModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RequiredArgsConstructor
public abstract class AbstractCurrencyService<MODEL extends BankModel> {

    private final RestTemplate restTemplate;
    private final Class<MODEL[]> clazz;

    public List<BankModel> getCurrentCurrencies(String[] arrCurrencies) {//почему нельзя1 List<MODEL>
        ResponseEntity<MODEL[]> response = restTemplate.getForEntity(getApiUrl(), clazz);
        List<MODEL> filteredCurrencies = new ArrayList<>();
        if (HttpStatus.OK.equals(response.getStatusCode())) {
            MODEL[] currencies = response.getBody();
            if (currencies != null) {
                for (MODEL currency : currencies) {
                    if((arrCurrencies != null)
                   /* && (arrCurrencies[0] == "def")*/){
                        List<String> listCurrency = new ArrayList<>(Arrays.asList(arrCurrencies));
                        if (listCurrency.contains(currency.getFrom())
                                && CurrencyConstant.UAH_CURRENCY.equals(currency.getTo())) {
                            filteredCurrencies.add(currency);
                        }
                    }
                    else if (CurrencyConstant.FOREIGN_CONCURRENCY.contains(currency.getFrom())//FOREIGN_CONCURRENCY=ВНЕШНЯЯ ВАЛЮТА
                            && CurrencyConstant.UAH_CURRENCY.equals(currency.getTo())) {
                       filteredCurrencies.add(currency);
                    }
                }
            }
        }
        return (List<BankModel>) filteredCurrencies;//почему нельзя1 filteredCurrencies
    }

    public abstract String getApiUrl();

    public abstract String getBankName();
}
