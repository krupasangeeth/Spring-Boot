package com.spring.jpa.jpaapplication;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.spring.jpa.jpaapplication.ER_Repository.S_Repository;
import com.spring.jpa.jpaapplication.EntityRelationsShips.Review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Transactional
@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	// @Autowired
	// private EmployeeJPArepo ejpa;

	@Autowired
	private S_Repository s_repo;

	@Autowired
	EntityManager em;

	private Logger logger=LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	
	// System.out.println(er.findAll());
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		// ejpa.save(new EmployeeDB(45,"krupa","hyd",Long.valueOf(100),"Google"));
		// EmployeeDB edb=ejpa.findById(2);
		// logger.info("{}",edb.toString());
		// List l =  em.createQuery("Select e From EmployeeDB e").getResultList();
		// ejpa.playingWithEM();


		//JPQL

		// logger.info("Select e From employeedb e - > {}", ejpa.JPQLCreateQuery());
		// logger.info("Select e From employeedb e - > {}", ejpa.JPQLTypedQuery());
		// logger.info("Select e From employeedb e - > {}", ejpa.JPQL_where());

		//Native Query
		// logger.info("Select e From employeedb e - > {}", ejpa.Native_Query());
		// logger.info("Select e From employeedb e - > {}", ejpa.Native_Query_parameter());
		// logger.info("Select e From employeedb e - > {}", ejpa.Native_Query_named_parameter());
		// logger.info("Select e From employeedb e - > {}", ejpa.Native_Query_Update());

		//EntityRelationShips
			// One to One
				
				// logger.info("Select e From employeedb e - > {}", s_repo.saveStudentWithPassport());
				// logger.info("One to One Retrival", s_repo.OneToOneFetch());
				// logger.info("One to One persistence context ", s_repo.persistenceContextUnderstanding());
				// s_repo.persistenceContextUnderstanding();
				// logger.info("One to One persistence context ",s_repo.Retrivestudentfrompassport());

			// One To Many
			// List<Review> r=new ArrayList<>();
			// r.add(new Review(1810,2,"good subject"));
			// r.add(new Review(1811,2,"Excellent"));
			
			// r.add(new Review(1812,5,"Mind Blowing"));
			
			// r.add(new Review(1813,9,"Awsome"));
			
			// r.add(new Review(1814,11,"Stunning"));
			
			List<Review> r=s_repo.OnetoManyExample2();
			logger.info("One to Many example ",r.get(1).getR_comment());



	}	
	
}
