package com.employeemanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
@Entity
@Data
@ToString
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eno;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private Double sal;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date doj;
    @Column
    private  Double hra;
    @Column
    private Double da;
    @Column
    private Double tax;
    @Column
    private  Double gross;
}
