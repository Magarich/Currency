package com.example.valuta.demo.util;

import com.example.valuta.demo.db.BankRepository;
import com.example.valuta.demo.db.entiy.Monobank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;


@Component
//@RequiredArgsConstructor
public class AutoPolling {

    private final BankRepository bankRepository;


    public AutoPolling(@Autowired BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Scheduled(fixedRate = 1000)
    public void poll() throws InterruptedException{
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        Monobank monobank = Monobank.builder()
                .buyUSD(2.3f)
                .sellUSD(3.4f)
                .buyEUR(4.5f)
                .sellEUR(6.7f)
                .build();
        bankRepository.save(monobank);

    }


    @Scheduled(fixedRate = 5000)
    public void deleteAll(){
        bankRepository.deleteAll();
    }
}
