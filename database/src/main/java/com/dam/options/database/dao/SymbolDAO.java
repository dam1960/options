/*
 * Copyright (c) 2017. David A. Miranda
 */

package com.dam.options.database.dao;

import com.dam.options.database.model.Symbol;

import java.util.List;
import java.util.Map;

public interface SymbolDAO {

    int save(List<Symbol> symbols);

    List<Map<String, Object>> getAllSymbols();


    List<Map<String, Object>> getAllEnabledSymbols();
}
