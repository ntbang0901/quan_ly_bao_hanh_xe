package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.Role;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import com.cnpm.baohanhxe.model.MyUserDetails;
import com.cnpm.baohanhxe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountService accountService;
    @Autowired
    HttpSession session;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        TaiKhoan user = accountService.getUserByUsername(username);

        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        if(user.isEnabled()){
            session.setAttribute("username",user.getUsername());
            Object ruri = session.getAttribute("redirect-uri");
            if(ruri != null){
                session.removeAttribute("redirect-uri");
            }

            return new MyUserDetails(user);
        }
        else{
            throw new UsernameNotFoundException("Account is disabled");
        }
    }
}
