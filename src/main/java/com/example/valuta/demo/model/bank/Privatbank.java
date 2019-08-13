package com.example.valuta.demo.model.bank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Optional;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Privatbank implements BankModel {

        @JsonProperty("ccy")
        private String from;

        @JsonProperty("base_ccy")
        private String to;

        @JsonProperty("buy")
        private Double buy;

        @JsonProperty("sale")
        private Double sell;
}
