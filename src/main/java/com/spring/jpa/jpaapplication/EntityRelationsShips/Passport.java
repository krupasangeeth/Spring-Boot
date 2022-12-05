package com.spring.jpa.jpaapplication.EntityRelationsShips;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Passport {

    @Id
    private int p_id;

    private String p_number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "s_passport")
    private Student p_student;


    
    public Passport() {
        
    }

    public Passport(int p_id, String p_number) {
        this.p_id = p_id;
        this.p_number = p_number;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_number() {
        return p_number;
    }

    public void setP_number(String p_number) {
        this.p_number = p_number;
    }
    
    public Student getP_student() {
        return p_student;
    }

    public void setP_student(Student p_student) {
        this.p_student = p_student;
    }


    @Override
    public String toString() {
        return "Passport [p_id = " + p_id + ", p_number=" + p_number +  " ]";
    }
}
