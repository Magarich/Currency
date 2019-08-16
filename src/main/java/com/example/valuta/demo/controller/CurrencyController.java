package com.example.valuta.demo.controller;

import com.example.valuta.demo.model.Currency;
import com.example.valuta.demo.service.GeneralCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final GeneralCurrencyService generalCurrencyService;

    @GetMapping("/currency")
    public Currency getCurrency(@RequestParam(name = "name", defaultValue = "def") String[] banks,
                                @RequestParam(name = "currency", defaultValue = "def") String[] currency){
        return generalCurrencyService.getCurrency(banks, currency);
    }
}
