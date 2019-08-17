package com.example.valuta.demo.db.entiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Jpa
@Entity //(сущность)вот это клас будет мапиться на таблицу
@Table(name = "monobank") //
public class Monobank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "buy_usd")
    private Float buyUSD;

    @Column(name = "sell_usd")
    private Float sellUSD;

    @Column(name = "buy_eur")
    private Float buyEUR;

    @Column(name = "sell_eur")
    private Float sellEUR;

}
