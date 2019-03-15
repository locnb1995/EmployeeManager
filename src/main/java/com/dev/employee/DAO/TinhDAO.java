package com.dev.employee.DAO;


import com.dev.employee.mapper.TinhMapper;
import com.dev.employee.model.Tinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class TinhDAO extends JdbcDaoSupport {

    @Autowired
    public TinhDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Tinh> getTinhInfo(){
        String sql = "SELECT * FROM tinh";
        Object[] params = new Object[] {};
        TinhMapper map = new TinhMapper();
        List<Tinh> list = this.getJdbcTemplate().query(sql,params,map);
        return list;
    }

    public Long getIdTinhByName(String name){
        String sql = "SELECT * FROM tinh WHERE name LIKE '"+name+"'";
        Object[] params = new Object[] {};
        TinhMapper map = new TinhMapper();
        List<Tinh> list = this.getJdbcTemplate().query(sql,params,map);
        long id = 0;
        for (int i = 0 ; i < list.size() ; i++){
           id = list.get(i).getId_tinh();
        }
        return id;
    }

}
