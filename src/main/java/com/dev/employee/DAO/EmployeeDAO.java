package com.dev.employee.DAO;

import com.dev.employee.mapper.EmployeeMapper;
import com.dev.employee.model.Employee;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class EmployeeDAO extends JdbcDaoSupport {

    @Autowired
    public EmployeeDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Employee> getEmployeeInfo(){
        String sql = "SELECT nv.id_nhanvien , nv.name , nv.age , t.name as tinh , h.name as huyen , x.name as xa " +
                "FROM nhanvien as nv " +
                "INNER JOIN nhanvien_address as nva ON nv.id_nhanvien = nva.id_nhanvien " +
                "INNER JOIN tinh as t ON nva.id_tinh = t.id_tinh " +
                "INNER JOIN huyen as h ON nva.id_huyen = h.id_huyen " +
                "INNER JOIN xa as x ON nva.id_xa = x.id_xa WHERE 1 ORDER BY id_nhanvien ASC";
        Object[] params = new Object[] {};
        EmployeeMapper map = new EmployeeMapper();
        List<Employee> list = this.getJdbcTemplate().query(sql,params,map);
        return list;
    }

    public List<Employee> pagination(int rowperpage , int page){
        int pagination = (page*rowperpage) - rowperpage;
        String sql = "SELECT nv.id_nhanvien , nv.name , nv.age , t.name as tinh , h.name as huyen , x.name as xa " +
                "FROM nhanvien as nv " +
                "INNER JOIN nhanvien_address as nva ON nv.id_nhanvien = nva.id_nhanvien " +
                "INNER JOIN tinh as t ON nva.id_tinh = t.id_tinh " +
                "INNER JOIN huyen as h ON nva.id_huyen = h.id_huyen " +
                "INNER JOIN xa as x ON nva.id_xa = x.id_xa ORDER BY id_nhanvien ASC LIMIT "+pagination+","+rowperpage;
        Object[] params = new Object[] {};
        EmployeeMapper map = new EmployeeMapper();
        List<Employee> list = this.getJdbcTemplate().query(sql,params,map);
        return list;
    }



}
