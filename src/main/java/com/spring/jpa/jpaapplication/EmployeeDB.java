package com.spring.jpa.jpaapplication;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
@NamedQueries(
    {
        @NamedQuery(name = "Select_query", query = "Select e From EmployeeDB e"),
        @NamedQuery(name = "Where_Query", query = "Select e From EmployeeDB e where employeeName like '%kru%'")
    }
)

public class EmployeeDB {

    @Id
    private int ID;

    // (name = "Full_Name", nullable = false)
    @Column
    private String employeeName;
    
    //(name = "Location")
    @Column
    private String employeeLocation;

    private Long employeeSalary;
    private String Company;
    private String FatherName;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedTime;

    @CreationTimestamp
    private LocalDateTime lastCreatedTime;

    public EmployeeDB() {
     
    }

    public EmployeeDB(int iD, String employeeName, String employeeLocation, Long employeeSalary, String company) {
        ID = iD;
        this.employeeName = employeeName;
        this.employeeLocation = employeeLocation;
        this.employeeSalary = employeeSalary;
        this.Company = company;
    }




    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    @Override
    public String toString() {
        return "EmployeeDB [Company=" + Company + ", ID=" + ID + ", employeeLocation=" + employeeLocation
                + ", employeeName=" + employeeName + ", employeeSalary=" + employeeSalary + "]";
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLocation() {
        return employeeLocation;
    }

    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getCompany() {
        return Company;
    }


    public void setCompany(String company) {
        this.Company = company;
    }

    
}
