/*
 * Copyright (c) 2017. David A. Miranda
 */

package com.dam.options.charts;

import com.dam.options.database.dao.ChartDAO;
import com.dam.options.database.dao.ChartDAOImpl;
import com.dam.options.database.dao.SymbolDAO;
import com.dam.options.database.dao.SymbolDAOImpl;
import com.dam.options.database.model.Chart;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ChartsApplication {

    private String url = "https://api.iextrading.com/1.0/stock/a/chart/1y";

    public static void main(String[] args) {
        SpringApplication.run(ChartsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

	@Bean
    public ChartDAO chartDAO() {
        return new ChartDAOImpl();
    }

    @Bean
    public SymbolDAO symbolDAO() {
        return new SymbolDAOImpl();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {

            List<Map<String, Object>> allSymbols = symbolDAO().getAllSymbols();

            for(Map<String, Object> symbolRow : allSymbols) {
                String symbol = symbolRow.get("symbol").toString();
                url = String.format("https://api.iextrading.com/1.0/stock/%s/chart/1y", symbol);

                Chart[] chartsArray = restTemplate.getForObject(url, Chart[].class);
                List<Chart> charts = Arrays.asList(chartsArray);
                chartDAO().save(charts, symbol);
            }
        };
    }
}
