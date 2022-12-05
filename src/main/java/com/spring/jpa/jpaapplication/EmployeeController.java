package com.spring.jpa.jpaapplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class EmployeeController {
    @RequestMapping("195255")
    @ResponseBody
    public String print()
    {
       return "Welcome to Servlets";
    }
}
