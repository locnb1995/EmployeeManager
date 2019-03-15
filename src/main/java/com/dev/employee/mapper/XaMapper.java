package com.dev.employee.mapper;

import com.dev.employee.model.Xa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class XaMapper implements RowMapper<Xa> {
    @Override
    public Xa mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id_xa = resultSet.getLong("id_xa");
        Long id_huyen = resultSet.getLong("id_huyen");
        String name = resultSet.getString("name");

        Xa district = new Xa(id_xa,id_huyen,name);

        return district;
    }
}
