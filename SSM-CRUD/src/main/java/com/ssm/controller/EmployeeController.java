package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;
import com.ssm.bean.Msg;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理员工crud请求
 * /emp/{id} GET 查询员工
 * /emp      POST 保存员工
 * /emp/{id} PUT 修改员工
 * /emp/{id} DELETE 删除员工
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().putValue("pageInfo", page);
    }

    //保存用户信息
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee employee) {
        if(employeeService.saveEmp(employee)){
            return Msg.success();
        }
        return Msg.fail();
    }

    //检验用户名是否重名
    @RequestMapping("/checkuser")
    @ResponseBody
    public Msg checkUser(@RequestParam(value = "empname") String empName){
        boolean hasEmp = employeeService.checkUser(empName);
        if(hasEmp){
            return Msg.success();
        }
        return Msg.fail();
    }

}
