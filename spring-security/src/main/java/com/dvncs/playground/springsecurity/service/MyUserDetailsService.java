package com.dvncs.playground.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;


    //1, filter configured
    //2, try to retrieve user by name **this method with DaoAuthenticationProvider
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //database or in memory
        //no encryption
//        1.
//        UserDetails userDetails = new User("deven", "{noop}123456",
//            AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
//        2.
//        String password = BCrypt.hashpw("123456", BCrypt.gensalt());
//        UserDetails userDetails = new User("deven", "{bcrypt}" + password,
//            AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));

//        3.
        UserDetails userDetails = new User("deven", passwordEncoder.encode("123456"),
            AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));

        return userDetails;
    }
}
