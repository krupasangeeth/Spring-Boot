package com.spring.jpa.jpaapplication.ER_Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.spring.jpa.jpaapplication.EntityRelationsShips.Course;
import com.spring.jpa.jpaapplication.EntityRelationsShips.Passport;
import com.spring.jpa.jpaapplication.EntityRelationsShips.Review;
import com.spring.jpa.jpaapplication.EntityRelationsShips.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class S_Repository {

    @Autowired
    EntityManager em;

  

    public Student findById(int id){
        return em.find(Student.class, id);
    }

    public Student save(Student sdb){

        if(sdb.getS_name()== null){
            em.persist(sdb);
        }
        else{
            em.merge(sdb);
        }
        return sdb;
    }

    public void deleteById(int id){
        Student sbd=em.find(Student.class, id);
        em.remove(sbd);
    }

    public String OneToOneFetch(){
        Student s=em.find(Student.class, 2);
        String str=s.toString();
        // str=s+ " "+ s.getPassport();
        return str;
    }

    public Student saveStudentWithPassport(){
        Passport p=new Passport(1, "P0201771");
        em.persist(p);


        Student s=new Student("Krupa Sangeeth", p);
        em.persist(s);
        return s;
    }
    public void persistenceContextUnderstanding(){

        Student s=em.find(Student.class, 2);

        Passport p=em.find(Passport.class, 1);

        s.setS_name("Krupa Sangeeth Jetti");

        p.setP_number("p0201772");
        
        String str=s.toString();
        str=str+" "+p.toString();
        
    }

    public Passport Retrivestudentfrompassport(){

        Passport p=em.find(Passport.class, 1);
        Student s = p.getP_student();
        return p;

    }

    public String OnetoManyExampleHardCoded(){

        Course c1= em.find(Course.class, 31);
        Course c2= em.find(Course.class, 35);

        Review r1=new Review(187,6,"good subject");

        Review r2=new Review(189,6,"good subject");

        c1.add_review(r1);
        r1.setR_course_id(c1);

        c2.add_review(r2);
        r2.setR_course_id(c2);

        em.persist(r1);
        em.persist(r2);

        return c1.toString();
    }
    
    public String OnetoManyExample(int cid,List<Review> reviews){

        Course course= em.find(Course.class, cid);
       
        for(Review review : reviews)
        {
            course.add_review(review);
            review.setR_course_id(course);
            em.persist(review);
    
        }
        return course.toString();
    }
    @Transactional
    public List<Review> OnetoManyExample2(){

        Course course= em.find(Course.class, 35);
        return course.getC_review();

    }
    
}
