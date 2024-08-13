package com.ata.test.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ata.test.demo.db.entity.JobSalary;
import com.ata.test.demo.db.repository.JobSalaryRepository;
import com.ata.test.demo.service.specification.JobSalarySearchCriteria;
import com.ata.test.demo.service.specification.JobSalarySearchSpecification;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class JobSalarySearchService {

    private JobSalaryRepository jobSalaryRepository;

    public List<JobSalary> searchByCriteria(JobSalarySearchCriteria criteria) {
        Pageable pageRequest = getPagination(criteria);
        Page<JobSalary> page = jobSalaryRepository.findAll(new JobSalarySearchSpecification(criteria), pageRequest);
        return page.stream().toList();
    }

    private Pageable getPagination(JobSalarySearchCriteria criteria){
        int pageSize = 1000;
        String sort = "id";

        if(!Objects.isNull(criteria.getSort())){
            sort = criteria.getSort();
        }

        if(!Objects.isNull(criteria.getRecords())){
            pageSize = criteria.getRecords();
        }

        if(Objects.equals(criteria.getSortType(),"DESC")){
            return PageRequest.of(0, pageSize, Sort.by(Sort.Direction.DESC, sort));
        } else {
            return PageRequest.of(0, pageSize, Sort.by(Sort.Direction.ASC, sort));
        }
    }
}
