package com.example.valuta.demo.model;

import com.example.valuta.demo.model.bank.BankModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    private Date date;
    private Map<String, List<BankModel>> source = new HashMap<>();
}
