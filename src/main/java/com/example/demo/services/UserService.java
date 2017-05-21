package com.example.demo.services;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kraet on 13.05.2017.
 */
@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public User add(User user) {

        jdbcTemplate.update("INSERT INTO users(name, password, enabled) VALUES(?, ?, ?)", user.getName(), user.getPassword(), "true");
        int id = jdbcTemplate.queryForObject("select id from users where name=?", Integer.class, user.getName());
        user.setId(id);
        return user;
    }

    public void delete(User user) {
        jdbcTemplate.update("delete from users where name = ?", user.getName());
    }

    public User update(User user) {

        jdbcTemplate.update("update users set name=? , password=? where id = ?", user.getName(), user.getPassword(), user.getId());
        return user;
    }

    public User getUserByUserName(String name) {
        String sql = "SELECT * FROM users where name=?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User aUser = new User();
                aUser.setId(rs.getInt("id"));
                aUser.setName(rs.getString("name"));
                aUser.setPassword(rs.getString("password"));
                return aUser;
            }
        }, name);
        return user;
    }

    public List<User> list() {
        String sql = "SELECT * FROM users";
        List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User aUser = new User();

                aUser.setId(rs.getInt("id"));
                aUser.setName(rs.getString("name"));
                aUser.setPassword(rs.getString("password"));


                return aUser;
            }

        });

        return listUser;
    }
}