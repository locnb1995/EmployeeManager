package com.dev.employee.DAO;

import com.dev.employee.mapper.AppUserMapper;
import com.dev.employee.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class AppUserDAO extends JdbcDaoSupport {

    @Autowired
    public AppUserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<AppUser> getListUser(String sql){
        Object[] params = new Object[] {};
        AppUserMapper map = new AppUserMapper();
        List<AppUser> list = this.getJdbcTemplate().query(sql,params,map);
        return list;
    }

    public List<AppUser> findUserByUsername(String username){
        String sql = "SELECT u.USER_ID , u.USER_NAME , u.ENCRYTED_PASSWORD , ar.ROLE_NAME FROM `app_user` as u " +
                "INNER JOIN `user_role`as ur ON u.USER_ID = ur.USER_ID " +
                "INNER JOIN `app_role` as ar ON ur.ROLE_ID = ar.ROLE_ID WHERE u.ENABLED = 1 AND u.USER_NAME = '"+username+"'";
        List<AppUser> list = getListUser(sql);
        return list;
    }

}
