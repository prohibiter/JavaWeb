package com.ssm.test;


import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/*
 * 使用spring提供的测试请求功能，测试crud的正确性
 * */
@RunWith(SpringJUnit4ClassRunner.class)
//帮助获取webmvc的ioc
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springMVC.xml"})
public class MVCTest {

    //获取springmvc的ioc
    @Autowired
    WebApplicationContext webApplicationContext;

    // 虚拟mvc请求，获取请求处理结果
    MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testPage() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();

        //请求成功后，请求域中会有pageinfo，我们可以取出进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println(pageInfo);
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("页面连续显示的页码：");
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        for (int page :
                navigatepageNums) {
            System.out.print(" " + page);
        }
        List<Employee> list = pageInfo.getList();
        for (Employee employee :
                list) {
            System.out.println(employee);
        }
    }

}
