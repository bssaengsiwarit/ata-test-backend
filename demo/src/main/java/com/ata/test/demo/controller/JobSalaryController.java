package com.ata.test.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ata.test.demo.webservice.JobSalarySearchTask;
import com.ata.test.demo.webservice.bean.JobSalarySearchRequest;
import com.ata.test.demo.webservice.bean.JobSalarySearchResponse;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/job_data")
public class JobSalaryController {

    private final JobSalarySearchTask jobSalarySearchTask;

    @GetMapping()
    public ResponseEntity<JobSalarySearchResponse> searchJobSalary(@RequestParam Map<String, String> params,
                                                   @RequestParam(value = "fields", required = false) String fields,
                                                   @RequestParam(value = "sort", required = false) String sort,
                                                   @RequestParam(value = "sort_type", required = false) String sortType,
                                                   @RequestParam(value = "records", required = false) Integer records) {
        JobSalarySearchRequest request = new JobSalarySearchRequest();
        request.setParams(params);
        request.setFields(fields);
        request.setSort(sort);
        request.setSortType(sortType);
        request.setRecords(records);

        JobSalarySearchResponse response = jobSalarySearchTask.processRequest(request);
        return ResponseEntity.ok(response);
    }
}