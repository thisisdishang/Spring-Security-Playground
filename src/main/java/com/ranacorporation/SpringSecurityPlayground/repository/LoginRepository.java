package com.ranacorporation.SpringSecurityPlayground.repository;

import com.ranacorporation.SpringSecurityPlayground.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LoginRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public LoginRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User u = new User(rs.getString("username"), rs.getString("password"));
            return u;
        }
    };

    public User authenticateUser(String username) {
        String query = "SELECT USERNAME, PASSWORD FROM AUTH_USER WHERE USERNAME = :USERNAME";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("USERNAME", username);

        List<User> resultList = namedParameterJdbcTemplate.query(query, params, userRowMapper);

        if (resultList.isEmpty()) {
            throw new UsernameNotFoundException("Failed to fetch Username: " + username);
        }

        return resultList.getFirst();
    }
}
