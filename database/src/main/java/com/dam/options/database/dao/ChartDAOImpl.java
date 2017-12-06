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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author david
 */
public class ChartDAOImpl implements ChartDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int save(final List<Chart> charts, final String symbol) {
        jdbcTemplate.batchUpdate("INSERT INTO dbo.chart " +
                "(symbol, [date], high, low, cloze, volume, unadjustedVolume, [change], changePercent, vwap, label, changeOverTime) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, symbol);
                ps.setDate(2, charts.get(i).getDate());
                ps.setDouble(3, charts.get(i).getHigh());
                ps.setDouble(4, charts.get(i).getLow());
                ps.setDouble(5, charts.get(i).getCloze());
                ps.setLong(6, charts.get(i).getVolume());
                ps.setLong(7, charts.get(i).getUnadjustedVolume());
                ps.setDouble(8, charts.get(i).getChange());
                ps.setDouble(9, charts.get(i).getChangePercent());
                ps.setDouble(10, charts.get(i).getVwap());
                ps.setString(11, charts.get(i).getLabel());
                ps.setBigDecimal(12, charts.get(i).getChangeOverTime());
            }

            @Override
            public int getBatchSize() {
                return charts.size();
            }
        });
        
        return 0;
    }
    
}
