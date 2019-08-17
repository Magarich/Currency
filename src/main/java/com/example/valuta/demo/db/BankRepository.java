package com.example.valuta.demo.db;

import com.example.valuta.demo.db.entiy.Monobank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sun.plugin2.message.Message;

public interface BankRepository extends JpaRepository<Monobank, Long> /*JpaRepository<Monobank, Long>*/ {

}
