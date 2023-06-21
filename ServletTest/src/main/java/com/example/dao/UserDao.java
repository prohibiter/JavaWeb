package com.example.dao;

import com.example.domain.User;
import com.example.utils.Druid;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//操作数据库
public class UserDao {
    //JdbcTemplate共用
    private JdbcTemplate jt = new JdbcTemplate(Druid.getDs());

    public User login(User loginUser){
        try {
            String sql = "select * from login where username = ? and password = ?";
            User user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
