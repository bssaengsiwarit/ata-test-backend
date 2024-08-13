package com.ata.test.demo.webservice.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class JobSalarySearchResponse {

    private List<Map<String, Object>> results;
}
