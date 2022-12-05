package com.spring.jpa.jpaapplication.EntityRelationsShips;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Student {
    
    @Id
    @GeneratedValue
    private int s_id;
    
    @Column(nullable = false)
    private String s_name;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Passport s_passport;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
    joinColumns = @JoinColumn(name = "STUDENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    public List<Course> course = new ArrayList<>();

    public int getS_id() {
        return s_id;
    }

    public Student() {
        
    }

    public Student(String s_name, Passport passport) {
        this.s_name = s_name;
        s_passport = passport;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Passport getPassport() {
        return s_passport;
    }

    public void setPassport(Passport passport) {
        s_passport = passport;
    }

    

    public List<Course> getCourse() {
        return course;
    }

    public void addCourse(Course course) {
        this.course.add(course);
    }

    @Override
    public String toString() {
        return "Passport [s_id = " + s_id + ", s_name=" + s_name + ", s_passport=" + s_passport +  " ]";
    }
   
    
}
