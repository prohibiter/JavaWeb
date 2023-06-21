package com.spring.service;

import com.spring.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public void accountMoney() {
//        try{
//            //1、开启事务
//
        //2、执行业务操作
        accountDao.addMoney("lucy", 100);

        //3、模拟异常
        int i = 10/0;

        //4、业务操作
        accountDao.subtractMoney("mary", 100);
//
//            //5、没有异常，提交事务
//        }catch(Exception e){
//            //6、出现异常，事务回滚
//
//        }


    }

}
