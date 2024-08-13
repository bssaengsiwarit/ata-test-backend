package com.ata.test.demo.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "job_salary", schema = "job_data")
public class JobSalary {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "employer")
    private String employer;

    @Column(name = "location")
    private String location;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "years_at_employer")
    private Integer yearsAtEmployer;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "signing_bonus")
    private Integer signingBonus;

    @Column(name = "annual_bonus")
    private Integer annualBonus;

    @Column(name = "annual_stock_value_bonus")
    private Integer annualStockValueBonus;

    @Column(name = "gender")
    private String gender;

    @Column(name = "additional_comments")
    private String additionalComments;

}
