package com.spring.jpa.jpaapplication.EntityRelationsShips;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {

    @Id
    private int c_id;

    private String c_course_name;

    @OneToMany(mappedBy = "r_course_id")
    private List<Review> c_review = new ArrayList<>();

    @ManyToMany(mappedBy = "course")
    public List<Student> student = new ArrayList<>();

    
    public Course() {
       
    }

    public Course(int c_id, String c_course_name) {
        this.c_id = c_id;
        this.c_course_name = c_course_name;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_course_name() {
        return c_course_name;
    }

    public void setC_course_name(String c_course_name) {
        this.c_course_name = c_course_name;
    }

    public List<Review> getC_review() {
        return c_review;
    }

    public void add_review(Review c_review) {
        this.c_review.add(c_review);
    }

    public void remove_review(Review c_review) {
        this.c_review.remove(c_review);
    }
    
    

    public List<Student> getStudent() {
        return student;
    }

    public void addStudent(Student student) {
        this.student.add(student);
    }

    @Override
    public String toString() {
        return "Course [c_course_name=" + c_course_name + ", c_id=" + c_id + ", c_review=" + c_review + "]";
    }

    
    


    
}
