package com.example.valuta.demo;

import com.example.valuta.demo.db.entiy.Monobank;
import com.example.valuta.demo.util.AutoPolling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(DemoApplication.class, args);

    }

}
