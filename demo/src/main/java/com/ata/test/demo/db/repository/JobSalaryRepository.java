package com.ata.test.demo.db.repository;

import com.ata.test.demo.db.entity.JobSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSalaryRepository extends JpaRepository<JobSalary, String>, JpaSpecificationExecutor<JobSalary> {

}