package com.ssm.controller;

import com.ssm.bean.Department;
import com.ssm.bean.Msg;
import com.ssm.dao.DepartmentMapper;
import com.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeartmenttController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> departments = departmentService.getAll();
        return Msg.success().putValue("depts",departments);
    }

}
