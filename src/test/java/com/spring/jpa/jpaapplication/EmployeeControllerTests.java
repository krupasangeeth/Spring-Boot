package com.spring.jpa.jpaapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeControllerTests {
    
    @Test
    public void printTest(){
        // EmployeeController e=new EmployeeController();
        // int result=e.print();
        assertEquals(100, new EmployeeController().print());
    }
}
