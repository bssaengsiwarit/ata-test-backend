package com.ata.test.demo.webservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.ata.test.demo.db.entity.JobSalary;
import com.ata.test.demo.service.JobSalarySearchService;
import com.ata.test.demo.service.specification.JobSalarySearchCriteria;
import com.ata.test.demo.webservice.bean.JobSalarySearchRequest;
import com.ata.test.demo.webservice.bean.JobSalarySearchResponse;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JobSalarySearchTask {

    private final JobSalarySearchService jobSalarySearchService;

    public JobSalarySearchResponse processRequest(JobSalarySearchRequest request) {

        JobSalarySearchCriteria criteria = JobSalarySearchCriteria.fromJobSearchRequest(request);

        List<JobSalary> jobSalaryList = jobSalarySearchService.searchByCriteria(criteria);
        return createResponse(jobSalaryList, request);
    }

    private JobSalarySearchResponse createResponse(List<JobSalary> jobSalaryList, JobSalarySearchRequest request) {
        JobSalarySearchResponse response = new   JobSalarySearchResponse();

        response.setResults(jobSalaryList.stream()
                .map(entity -> jobSalarySearchResult(entity, request))
                .toList());

        return response;
    }

    private Map<String, Object> jobSalarySearchResult(JobSalary entity, JobSalarySearchRequest request) {
        Map<String, Object> info = new LinkedHashMap<>();

        Set<String> fields = null;

        if(request.getFields() != null) {
            String[] fieldsArray = request.getFields().split(",");
            fields = Arrays.stream(fieldsArray)
                    .map(String::trim)
                    .collect(Collectors.toSet());
        }

        if (fields == null) {
            info.put("timestamp", entity.getTimestamp());
            info.put("employer", entity.getEmployer());
            info.put("location", entity.getLocation());
            info.put("jobTitle", entity.getJobTitle());
            info.put("yearsAtEmployer", entity.getYearsAtEmployer());
            info.put("yearsOfExperience", entity.getYearsOfExperience());
            info.put("salary", entity.getSalary());
            info.put("signingBonus", entity.getSigningBonus());
            info.put("annualBonus", entity.getAnnualBonus());
            info.put("annualStockValueBonus", entity.getAnnualStockValueBonus());
            info.put("gender", entity.getGender());
            info.put("additionalComments", entity.getAdditionalComments());
        } else {
            for (String field : fields) {
                switch (field) {
                    case "timestamp":
                        info.put("timestamp", entity.getTimestamp());
                        break;
                    case "employer":
                        info.put("employer", entity.getEmployer());
                        break;
                    case "location":
                        info.put("location", entity.getLocation());
                        break;
                    case "job_title":
                        info.put("jobTitle", entity.getJobTitle());
                        break;
                    case "years_at_employer":
                        info.put("yearsAtEmployer", entity.getYearsAtEmployer());
                        break;
                    case "years_of_experience":
                        info.put("yearsOfExperience", entity.getYearsOfExperience());
                        break;
                    case "salary":
                        info.put("salary", entity.getSalary());
                        break;
                    case "signing_bonus":
                        info.put("signingBonus", entity.getSigningBonus());
                        break;
                    case "annual_bonus":
                        info.put("annualBonus", entity.getAnnualBonus());
                        break;
                    case "annual_stock_value_bonus":
                        info.put("annualStockValueBonus", entity.getAnnualStockValueBonus());
                        break;
                    case "gender":
                        info.put("gender", entity.getGender());
                        break;
                    case "additional_comments":
                        info.put("additionalComments", entity.getAdditionalComments());
                        break;
                    default:
                        break;
                }
            }
        }
        return info;
    }
}