package com.ata.test.demo.webservice.bean;

import lombok.Data;

import java.sql.Timestamp;

@Data
public final class JobSalarySearchInfo {

    private Timestamp timeStamp;

    private String employer;

    private String location;

    private String jobTitle;

    private Integer yearsAtEmployer;

    private Integer yearsOfExperience;

    private Integer salary;

    private Integer signingBonus;

    private Integer annualBonus;

    private Integer annualStockValueBonus;

    private String gender;

    private String additionalComments;
}
