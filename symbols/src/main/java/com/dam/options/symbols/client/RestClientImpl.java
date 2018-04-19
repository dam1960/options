/*
 * Copyright (c) 2017. David A. Miranda
 */

package com.dam.options.symbols.client;

import com.dam.options.database.model.Symbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestClientImpl implements  RestClient {

    private String url = "https://api.iextrading.com/1.0/ref-data/symbols";

    private final RestTemplate restTemplate;

    @Autowired
    public RestClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Symbol> getSymbols() {

        Symbol[] symbolsArray = restTemplate.getForObject(url, Symbol[].class);
        List<Symbol> symbols = Arrays.asList(symbolsArray);

        return symbols;
    }
}
