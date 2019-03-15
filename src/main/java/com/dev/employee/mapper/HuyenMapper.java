package com.dev.employee.mapper;

import com.dev.employee.model.Huyen;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HuyenMapper implements RowMapper<Huyen> {

    @Override
    public Huyen mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id_huyen = resultSet.getLong("id_huyen");
        Long id_tinh = resultSet.getLong("id_tinh");
        String name = resultSet.getString("name");

        Huyen district = new Huyen(id_huyen,id_tinh,name);
        return district;
    }
}
