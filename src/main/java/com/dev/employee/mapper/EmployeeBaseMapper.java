package com.dev.employee.mapper;

import com.dev.employee.model.EmployeeBase;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeBaseMapper implements RowMapper<EmployeeBase> {
    @Override
    public EmployeeBase mapRow(ResultSet resultSet, int i) throws SQLException {

        Long id = resultSet.getLong("id_nhanvien");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");

        EmployeeBase emp = new EmployeeBase(id,name,age);
        return emp;
    }
}
