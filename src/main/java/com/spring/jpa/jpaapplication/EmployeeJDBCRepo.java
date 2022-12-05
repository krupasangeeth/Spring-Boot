package com.spring.jpa.jpaapplication;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@Controller
public class EmployeeJDBCRepo {

    @Autowired
    JdbcTemplate jdbctemplate;

    @RequestMapping("195255/Welcome")
    @ResponseBody
    public String print()
    {
       return "<h1>Welcome to Servlets<h1>";
    }

    @RequestMapping("find")
    @ResponseBody
    public List<EmployeeDB> findAll(){
       return jdbctemplate.query("select * from EmployeeDB", new BeanPropertyRowMapper<EmployeeDB>(EmployeeDB.class));
    }

    
}
