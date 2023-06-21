package com.ssm.service;

import com.ssm.bean.Employee;
import com.ssm.bean.EmployeeExample;
import com.ssm.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有员工的信息
     * @return
     */
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    /*
    * 员工保存
    * */
    public boolean saveEmp(Employee employee) {
        int result = employeeMapper.insertSelective(employee);
        return true;
    }

    /*
    * 检验用户名是否可用，true表示可用，false表示不可用
    * */
    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }
}
