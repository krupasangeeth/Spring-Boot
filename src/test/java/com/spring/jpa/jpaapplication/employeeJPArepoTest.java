package com.spring.jpa.jpaapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class employeeJPArepoTest {

    @Autowired
    private EmployeeJPArepo era;

    @Test
    public void findByID(){
        EmployeeDB edb=era.findById(2);
        assertEquals("Sangeeth", edb.getEmployeeName());
    }

    @Test
    @DirtiesContext
    public void deleteByID(){
        era.deleteById(6);
        assertNull(era.findById(6));
    }


    @Test
    public void saveTest(){
        EmployeeDB edb=era.findById(15);
        assertEquals("Amazon", edb.getCompany());
        
       // update
       era.save(new EmployeeDB(15,"krupa","hyd",Long.valueOf(1000),"deloitte"));
		
    //  checking

        edb=era.findById(15);
        assertEquals("deloitte", edb.getCompany());

    }
}
