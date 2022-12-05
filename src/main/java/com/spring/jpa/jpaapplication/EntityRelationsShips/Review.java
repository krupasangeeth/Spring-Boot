package com.spring.jpa.jpaapplication.EntityRelationsShips;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
    
    @Id
    private int r_id;

    private int r_rating;

    private String r_comment;

    @ManyToOne
    private Course r_course_id;

    public Review() {
        
    }

    

    public Review(int r_id, int r_rating, String r_comment) {
        this.r_id = r_id;
        this.r_rating = r_rating;
        this.r_comment = r_comment;
    }



    public Review(int r_id, int r_rating, String r_comment, Course r_course_id) {
        this.r_id = r_id;
        this.r_rating = r_rating;
        this.r_comment = r_comment;
        this.r_course_id = r_course_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getR_rating() {
        return r_rating;
    }

    public void setR_rating(int r_rating) {
        this.r_rating = r_rating;
    }

    public String getR_comment() {
        return r_comment;
    }

    public void setR_comment(String r_comment) {
        this.r_comment = r_comment;
    }

    public Course getR_course_id() {
        return r_course_id;
    }

    public void setR_course_id(Course r_course_id) {
        this.r_course_id = r_course_id;
    }

    

}
