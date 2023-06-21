package com.ssm.test;

import com.ssm.bean.Department;
import com.ssm.bean.Employee;
import com.ssm.bean.EmployeeExample;
import com.ssm.dao.DepartmentMapper;
import com.ssm.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * dao层测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test() {
        /*departmentMapper.insertSelective(new Department(null, "开发部"));
        departmentMapper.insertSelective(new Department(null, "测试部"));
        employeeMapper.insert(new Employee(null,"Jerry","M","Jerry@gmail.com",1));
        //插入多个员工信息 使用批量操作的sqlsession
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null, uid, "M", uid + "@gmail.com", 1));
        }*/


        Employee employee = employeeMapper.selectByPrimaryKey(1);
        System.out.println(employee);
    }
}
