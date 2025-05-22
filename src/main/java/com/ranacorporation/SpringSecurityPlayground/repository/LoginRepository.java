package com.ranacorporation.SpringSecurityPlayground.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public LoginRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void authenticateUser(String username) {

    }
}
