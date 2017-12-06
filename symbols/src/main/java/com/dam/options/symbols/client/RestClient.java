package com.dam.options.symbols.client;

import com.dam.options.database.model.Symbol;

import java.util.List;

public interface RestClient {

    List<Symbol> getSymbols();

}
