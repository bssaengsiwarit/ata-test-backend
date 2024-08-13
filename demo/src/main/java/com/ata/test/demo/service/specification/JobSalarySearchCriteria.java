package com.ata.test.demo.service.specification;

import lombok.Builder;
import lombok.Data;
import com.ata.test.demo.webservice.bean.JobSalarySearchRequest;

import java.util.Map;

@Data
@Builder
public class JobSalarySearchCriteria {

    private Map<String, String> params;

    private String fields;

    private String sort;

    private String sortType;

    private Integer records;

    public static JobSalarySearchCriteria fromJobSearchRequest(JobSalarySearchRequest request) {
        return JobSalarySearchCriteria.builder()
                .params(request.getParams())
                .fields(request.getFields())
                .sort(request.getSort())
                .sortType(request.getSortType())
                .records(request.getRecords())
                .build();
    }
}
