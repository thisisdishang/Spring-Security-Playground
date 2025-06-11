package com.ranacorporation.SpringSecurityPlayground.service;

import com.ranacorporation.SpringSecurityPlayground.model.SecurityUser;
import com.ranacorporation.SpringSecurityPlayground.model.User;
import com.ranacorporation.SpringSecurityPlayground.repository.LoginRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginDetailsService implements UserDetailsService {

    private final LoginRepository loginRepository;

    public LoginDetailsService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = loginRepository.authenticateUser(username);
        return new SecurityUser(user);
    }
}
