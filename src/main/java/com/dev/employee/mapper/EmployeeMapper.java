package com.dev.employee.mapper;

import com.dev.employee.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

        Long id = resultSet.getLong("id_nhanvien");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String tinh = resultSet.getString("tinh");
        String huyen = resultSet.getString("huyen");
        String xa = resultSet.getString("xa");

        Employee emp = new Employee(id,name,age,tinh,huyen,xa);
        return emp;
    }
}
