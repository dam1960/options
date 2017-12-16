/*
 * Copyright (c) 2017. David A. Miranda
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.options.database.dao;

import com.dam.options.database.model.Chart;

import java.util.List;

/**
 *
 * @author david
 */
public interface ChartDAO {
    
    int save(List<Chart> charts, String symbol);

    void processAllData();
    
}
