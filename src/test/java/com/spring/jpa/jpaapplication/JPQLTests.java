package com.spring.jpa.jpaapplication;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import ch.qos.logback.classic.Logger;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class JPQLTests {

    private Logger logger=(Logger) LoggerFactory.getLogger(this.getClass());
   
    @Autowired
    EntityManager em;

    @Test
    public void JPQLCreateQuery(){

    List l =  em.createQuery("Select e From EmployeeDB e").getResultList();
        logger.info("Select e From employeedb e - > {}", l);

    }
}
