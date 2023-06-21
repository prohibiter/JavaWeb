package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMoney(String username,int money){
        String sql = "update t_account set money=money+? where username=?";
        int update = jdbcTemplate.update(sql, money, username);
        System.out.println(update);
    }

    public void subtractMoney(String username,int money){
        String sql = "update t_account set money=money-? where username=?";
        int update = jdbcTemplate.update(sql, money, username);
        System.out.println(update);
    }
}
