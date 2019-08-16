package com.example.valuta.demo.service;

import com.example.valuta.demo.model.Currency;
import com.example.valuta.demo.model.bank.BankModel;
import com.example.valuta.demo.model.bank.Monobank;
import com.example.valuta.demo.service.impl.MonobankCurrencyService;
import com.example.valuta.demo.service.impl.PrivatCurrencyService;
import lombok.RequiredArgsConstructor;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
@RequiredArgsConstructor
public class GeneralCurrencyService {

    private final MonobankCurrencyService monobankCurrencyService;
    private final PrivatCurrencyService privatCurrencyService;

    public Currency getCurrency(String[] banks, String[] currs) {



        Currency currency = new Currency();
        currency.setDate(new Date());
        Map<String, List<BankModel>> sources = new HashMap<>();
        /*
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Method getBankName = declaredField.getDeclaringClass().getDeclaredMethod("getBankName");
            String bankName = getBankName.invoke()
            for (String bank : banks) {
                if (bank.equals(bankName)) {
                    Method getCurrentCurencies = declaredField.getDeclaringClass().getDeclaredMethod("getCurrentCurencies");
                    List<BankModel> currencies = getCurrentCurencies.invoke()
                    sources.put(bankName, currencies);
                }
            }
        }*/
        if("def".equals(banks[0])) {
            sources.put(monobankCurrencyService.getBankName(), monobankCurrencyService.getCurrentCurrencies(currs));
            sources.put(privatCurrencyService.getBankName(), privatCurrencyService.getCurrentCurrencies(currs));
        }

            for (String bank : banks) {
                switch (bank) {
                    case ("privat"):
                        sources.put(privatCurrencyService.getBankName(), privatCurrencyService.getCurrentCurrencies(currs));
                        break;
                    case ("mono"):
                        sources.put(monobankCurrencyService.getBankName(), monobankCurrencyService.getCurrentCurrencies(currs));
                        break;
                    default:
                        sources.put(monobankCurrencyService.getBankName(), monobankCurrencyService.getCurrentCurrencies(currs));
                        sources.put(privatCurrencyService.getBankName(), privatCurrencyService.getCurrentCurrencies(currs));

                }
            }





//        Reflections reflections = new Reflections("com.example.valuta.demo.service.impl");
//
//        Set<Class<? extends AbstractCurrencyService>> allClasses =
//                reflections.getSubTypesOf(AbstractCurrencyService.class);
//
//        for (Class<?> allClass : allClasses) {
//            Method[] declaredMethods = allClass.getDeclaredMethods();
//            for (Method declaredMethod : declaredMethods) {
//                try {
//                    String bankName = null;
//                    List<BankModel> currencies = new ArrayList<>();
//                if ("getBankName".equals(declaredMethod.getName())) {
//                        bankName = (String) declaredMethod.invoke(allClass.newInstance());
//                }
//                if("getCurrentCurrencies".equals(declaredMethod.getName())) {
//                    currencies = (List<BankModel>) declaredMethod.invoke(allClass.newInstance());
//                }
//                if (bankName != null) {
//                    sources.put(bankName, currencies);
//                }
//            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
//                e.printStackTrace();
//            }
//            }
//        }
        currency.setSource(sources);
        return currency;
    }
}
