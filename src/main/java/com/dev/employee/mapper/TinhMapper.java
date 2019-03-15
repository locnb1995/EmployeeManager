package com.dev.employee.mapper;

import com.dev.employee.model.Tinh;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TinhMapper implements RowMapper<Tinh> {

    @Override
    public Tinh mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id_tinh = resultSet.getLong("id_tinh");
        String name = resultSet.getString("name");

        Tinh district = new Tinh(id_tinh,name);
        return district;
    }
}
