package com.spring.dao;

import org.springframework.stereotype.Repository;


public interface AccountDao {
    public void addMoney(String username,int money);
    public void subtractMoney(String username,int money);
}
