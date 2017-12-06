/*
 * Copyright (c) 2017. David A. Miranda
 */

package com.dam.options.symbols;

import com.dam.options.database.dao.SymbolDAO;
import com.dam.options.database.dao.SymbolDAOImpl;
import com.dam.options.database.model.Symbol;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SymbolsApplication {

    private String url = "https://api.iextrading.com/1.0/ref-data/symbols";

	public static void main(String[] args) {
		SpringApplication.run(SymbolsApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
	    return restTemplateBuilder.build();
    }

    @Bean
    public SymbolDAO symbolDAO() {
	    return new SymbolDAOImpl();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Symbol[] symbolsArray = restTemplate.getForObject(url, Symbol[].class);
            List<Symbol> symbols = Arrays.asList(symbolsArray);
            symbolDAO().save(symbols);
        };

    }
}
