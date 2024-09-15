package com.fabio.market.domain.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Log log = LogFactory.getLog(getClass());
        log.info("######### userDetails");
        User user = new User("fabio", "{noop}fabioyqcp7*", new ArrayList<>());
        log.info(user);
        return user;
    }
}
