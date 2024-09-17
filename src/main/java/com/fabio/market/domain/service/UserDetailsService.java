package com.fabio.market.domain.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Define roles
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // Rol de usuario
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        Log log = LogFactory.getLog(getClass());
        log.info("######### userDetails");
        User user = new User("userTest", "$2a$12$wSZQNiRGGWjnfV6G0K0OAutjQP0Rl9yvku/4ZKPTglxqmybLDBHN6", authorities );
        log.info(user);
        return user;
    }
}
