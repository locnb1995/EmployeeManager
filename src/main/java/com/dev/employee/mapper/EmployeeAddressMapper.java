package com.dev.employee.mapper;

import com.dev.employee.model.EmployeeAddress;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAddressMapper implements RowMapper<EmployeeAddress> {
    @Override
    public EmployeeAddress mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        Long id_tinh = resultSet.getLong("id_tinh");
        Long id_huyen = resultSet.getLong("id_huyen");
        Long id_xa = resultSet.getLong("id_xa");
        Long id_nhanvien = resultSet.getLong("id_nhanvien");

        EmployeeAddress emp = new EmployeeAddress(id,id_tinh,id_huyen,id_xa,id_nhanvien);
        return emp;
    }
}
