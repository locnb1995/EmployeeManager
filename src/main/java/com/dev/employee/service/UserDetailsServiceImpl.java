package com.dev.employee.service;

import com.dev.employee.DAO.AppUserDAO;
import com.dev.employee.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserDAO appUserDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<AppUser> list = appUserDAO.findUserByUsername(s);
        if(!list.isEmpty()){
            for (int i = 0 ; i < list.size() ; i++){
                String username = list.get(i).getUsername();
                String en_pass = list.get(i).getEncryt_password();
                String role = list.get(i).getRole();

                List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
                UserDetails userDetails = (UserDetails)new User(username,en_pass,grantList);
                return userDetails;
            }
        }
        throw new UsernameNotFoundException("User " + s + " was not found in the database");
    }

}
