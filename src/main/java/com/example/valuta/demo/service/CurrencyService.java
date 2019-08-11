package com.example.valuta.demo.service;

import com.example.valuta.demo.constant.CurrencyConstant;
import com.example.valuta.demo.model.Currency;
import com.example.valuta.demo.model.MonoCurrency;
import com.example.valuta.demo.model.PrivatCurrency;
import com.example.valuta.demo.model.Source;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.valuta.demo.constant.CurrencyConstant.MONO_UAH;

@Service
public class CurrencyService {
    private RestTemplate restTemplate = new RestTemplate();

    public Currency getCurrency() {
        Currency currency = new Currency();
        currency.setDate(new Date());
        List<Source> sources = new ArrayList<>();
        sources.add(getPrivatData());
        sources.add(getMonoData());
        currency.setSources(sources);
        return currency;
    }

    private Source getPrivatData() {
        ResponseEntity<PrivatCurrency[]> response = restTemplate.getForEntity(CurrencyConstant.PRIVAT_URL, PrivatCurrency[].class);
        if (HttpStatus.OK.equals(response.getStatusCode())) {
            PrivatCurrency[] privatCurrencies = response.getBody();
            if (privatCurrencies != null) {
                for (PrivatCurrency privatCurrency : privatCurrencies) {
                    if (CurrencyConstant.PRIVAT_FOREIGN_CONCURRENCY.contains(privatCurrency.getCcy())
                            && CurrencyConstant.PRIVAT_UAH.equals(privatCurrency.getBase_ccy())) {
                        return Source.builder()
                                .currency(privatCurrency.getCcy())
                                .name("Privat")
                                .value(Float.parseFloat(privatCurrency.getBuy()))
                                .build();
                    }
                }
            }
        }
        return null;
    }

    public Source getMonoData() {
        ResponseEntity<MonoCurrency[]> response = restTemplate.getForEntity(CurrencyConstant.MONO_URL, MonoCurrency[].class);
        if (HttpStatus.OK.equals(response.getStatusCode())) {
            MonoCurrency[] monoCurrencies = response.getBody();
            if (monoCurrencies != null) {
                for (MonoCurrency monoCurrency : monoCurrencies) {
                    if (CurrencyConstant.MONO_FOREIGN_CONCURRENCY.contains(monoCurrency.getCurrencyCodeA())
                            && MONO_UAH.equals(monoCurrency.getCurrencyCodeB())) {
                        return Source.builder()
                                .currency(getCurrencyNameFromCode(monoCurrency.getCurrencyCodeA()))
                                .name("Mono")
                                .value(monoCurrency.getRateBuy())
                                .build();
                    }
                }
            }
        }
        return null;
    }

    private String getCurrencyNameFromCode(Integer code) {
        switch (code) {
            case 980:
                return "UAH";
            case 840:
                return "USD";
            case 978:
                return "EUR";
            default:
                return null;
        }
    }
}
