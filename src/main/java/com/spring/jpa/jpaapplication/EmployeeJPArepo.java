package com.spring.jpa.jpaapplication;

import java.util.List;

import javax.persistence.EntityManager;
// import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeJPArepo {

    @Autowired
    EntityManager em;


    public EmployeeDB findById(int id){
        return em.find(EmployeeDB.class, id);
    }

    public EmployeeDB save(EmployeeDB edb){

        if(edb.getEmployeeName()== null){
            em.persist(edb);
        }
        else{
            em.merge(edb);
        }
        return edb;
    }

    public void deleteById(int id){
        EmployeeDB ebd=em.find(EmployeeDB.class, id);
        em.remove(ebd);
    }


    public void playingWithEM(){
        EmployeeDB edb1=new EmployeeDB(40,"Ramesh","hyd",Long.valueOf(17000),"Whatsapp");
        em.persist(edb1);
        EmployeeDB edb2=new EmployeeDB(41,"Babu","Ban",Long.valueOf(15000),"Instagram");
        em.persist(edb2);
        em.flush();
        //clearing Entity Manager
        // Long l1=edb1.getEmployeeSalary();
        // Long l2=edb2.getEmployeeSalary();
        edb1.setEmployeeSalary(Long.valueOf(25000));
        edb2.setEmployeeSalary(Long.valueOf(30000));

        em.refresh(edb1);
        em.refresh(edb2);

        // l1=edb1.getEmployeeSalary();
        // l2=edb2.getEmployeeSalary();
        // em.flush();
    }

//JPQL 

        // public List JPQLCreateQuery(){

        //     List l =  em.createNamedQuery("Select_query").getResultList();
        //     // logger.info("Select e From employeedb e - > {}", l);
        //     return l;

        // }

        public List<EmployeeDB> JPQLTypedQuery(){

            TypedQuery<EmployeeDB> query= em.createNamedQuery("Select_query",EmployeeDB.class);
            List<EmployeeDB> l=query.getResultList();
            return l;
        }

        public List<EmployeeDB> JPQL_where(){
            TypedQuery<EmployeeDB> query=em.createNamedQuery("Where_Query",EmployeeDB.class);
            List<EmployeeDB> l=query.getResultList();
            return l;
        }
//Native Queries

        // public List Native_Query(){
        //     Query q = em.createNativeQuery("Select * from employeeDB", EmployeeDB.class);
        //     List l =q.getResultList();
        //     return l;
        // }

        // public List Native_Query_parameter(){
        //     Query q = em.createNativeQuery("Select * from employeeDB where id = ?", EmployeeDB.class);
        //     q.setParameter(1, 10);
        //     List l =q.getResultList();
        //     return l;
        // }

        // public List Native_Query_named_parameter(){
        //     Query q = em.createNativeQuery("Select * from employeeDB where id = :id", EmployeeDB.class);
        //     q.setParameter("id", 11);
        //     List l =q.getResultList();
        //     return l;
        // }

        // @Transactional
        // public int Native_Query_Update(){
        //     Query q = em.createNativeQuery("Update employeeDB set last_updated_time = sysdate()", EmployeeDB.class);
        //     int n=q.executeUpdate();
        //     this.Native_Query();
        //     return n;
        // }


    
}
