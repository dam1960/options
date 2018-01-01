/*
 * Copyright (c) 2017. David A. Miranda
 */

package com.dam.options.database.dao;

import com.dam.options.database.model.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SymbolDAOImpl implements SymbolDAO {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(final List<Symbol> symbols) {

        SimpleJdbcCall clearData = new SimpleJdbcCall(jdbcTemplate).withProcedureName("prepareForReload");
        clearData.execute();

        jdbcTemplate.batchUpdate("INSERT INTO dbo.symbol (symbol, name, date, isEnabled) VALUES(?, ?, ?, ?)", new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) {
                logger.info("{}  Symbol: {}", i, symbols.get(i).toString());

                try {
                    preparedStatement.setString(1, symbols.get(i).getSymbol());
                    preparedStatement.setString(2, symbols.get(i).getName());
                    preparedStatement.setDate(3, symbols.get(i).getDate());
                    preparedStatement.setBoolean(4, symbols.get(i).getIsEnabled());
                } catch (SQLException e) {
                    logger.error("SQL Exception", e);
                }
            }

            @Override
            public int getBatchSize() {
                return symbols.size();
            }
        });

        return 0;
    }

    @Override
    public List<Map<String, Object>> getAllSymbols() {
        List<Map<String, Object>> symbols = jdbcTemplate.queryForList("SELECT * FROM dbo.symbol");

        return symbols;
    }

    @Override
    public List<Map<String, Object>> getAllEnabledSymbols() {
        List<Map<String, Object>> symbols = jdbcTemplate.queryForList("SELECT * FROM dbo.symbol where isEnabled = '1'");

        return symbols;
    }
}
