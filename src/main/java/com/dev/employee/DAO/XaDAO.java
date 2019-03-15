package com.dev.employee.DAO;

import com.dev.employee.mapper.XaMapper;
import com.dev.employee.model.Xa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class XaDAO extends JdbcDaoSupport {

    @Autowired
    public XaDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Xa> getXaInfo(){
        String sql = "SELECT * FROM xa";
        Object[] params = new Object[] {};
        XaMapper map = new XaMapper();
        List<Xa> list = this.getJdbcTemplate().query(sql,params,map);
        return list;
    }

    public List<Xa> getXaByHuyen(String id_huyen){
        String sql = "SELECT * FROM xa WHERE id_huyen = "+id_huyen;
        Object[] params = new Object[] {};
        XaMapper map = new XaMapper();
        List<Xa> list = this.getJdbcTemplate().query(sql,params,map);
        return list;
    }

    public Long getIdXaByName(String name){
        String sql = "SELECT * FROM xa WHERE name LIKE '"+name+"'";
        Object[] params = new Object[] {};
        XaMapper map = new XaMapper();
        List<Xa> list = this.getJdbcTemplate().query(sql,params,map);
        long id = 0;
        for (int i = 0 ; i < list.size() ; i++){
            id = list.get(i).getId_xa();
        }
        return id;
    }

}
