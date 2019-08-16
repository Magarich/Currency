package com.example.valuta.demo.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Configuration
@EnableScheduling
public class AutoPolling {

    @Async//If we want to support parallel behavior in scheduled tasks, we need to add the @Async annotation:
    @Scheduled(fixedRate = 1000)
    public void poll() throws InterruptedException{
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);

    }

}
