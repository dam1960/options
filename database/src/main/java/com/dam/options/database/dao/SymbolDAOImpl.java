package com.dam.options.database.dao;

import com.dam.options.database.model.Symbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SymbolDAOImpl implements SymbolDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(final List<Symbol> symbols) {
        jdbcTemplate.batchUpdate("insert into dbo.symbol (symbol, name, date, isEnabled) values(?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, symbols.get(i).getSymbol());
                preparedStatement.setString(2, symbols.get(i).getName());
                preparedStatement.setDate(3, symbols.get(i).getDate());
                preparedStatement.setBoolean(4, symbols.get(i).getIsEnabled());
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
        List<Map<String, Object>> symbols = jdbcTemplate.queryForList("select * from dbo.symbol");

        return symbols;
    }
}
