package com.example.test;

import com.example.domain.User;
import com.example.dao.UserDao;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("123");
        loginUser.setPassword("123");

        UserDao ud = new UserDao();
        User user = ud.login(loginUser);
        System.out.println(user.getUsername() + "/" + user.getPassword());
    }

}
