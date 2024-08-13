package com.ata.test.demo.webservice.bean;

import lombok.Data;

import java.util.Map;

@Data
public class JobSalarySearchRequest {

    private Map<String, String> params;

    private String fields;

    private String sort;

    private String sortType;

    private Integer records;
}
