package com.dev.employee.DAO;

import com.dev.employee.mapper.HuyenMapper;
import com.dev.employee.model.Huyen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class HuyenDAO extends JdbcDaoSupport {

    @Autowired
    public HuyenDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Huyen> getHuyenInfo(){
        String sql = "SELECT * FROM huyen";
        Object[] params = new Object[] {};
        HuyenMapper map = new HuyenMapper();
        List<Huyen> list = this.getJdbcTemplate().query(sql,params,map);
        return list;
    }
    public List<Huyen> getHuyenByTinh(String id_tinh){
        String sql = "SELECT * FROM huyen WHERE id_tinh = "+id_tinh;
        Object[] params = new Object[] {};
        HuyenMapper map = new HuyenMapper();
        List<Huyen> list = this.getJdbcTemplate().query(sql,params,map);
        return list;
    }

    public Long getIdHuyenByName(String name){
        String sql = "SELECT * FROM huyen WHERE name LIKE '"+name+"'";
        Object[] params = new Object[] {};
        HuyenMapper map = new HuyenMapper();
        List<Huyen> list = this.getJdbcTemplate().query(sql,params,map);
        long id = 0;
        for (int i = 0 ; i < list.size() ; i++){
            id = list.get(i).getId_huyen();
        }
        return id;
    }

}
