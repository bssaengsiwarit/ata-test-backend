package com.ata.test.demo.service.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import com.ata.test.demo.db.entity.JobSalary;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class JobSalarySearchSpecification implements Specification<JobSalary> {

    private final JobSalarySearchCriteria request;

    @Override
    public Predicate toPredicate(Root<JobSalary> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> criteria = new ArrayList<>();
        Map<String, String> params = request.getParams();

        params.forEach((key, value) -> {
            if(StringUtils.hasLength(value)) {
                if (key.startsWith("timestamp")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime localDateTime = LocalDateTime.parse(value, formatter);
                    Timestamp timestamp = Timestamp.valueOf(localDateTime);
                    if (key.endsWith("gte")) {
                        criteria.add(criteriaBuilder.greaterThanOrEqualTo(root.get("timestamp"), timestamp));
                    } else if (key.endsWith("lte")) {
                        criteria.add(criteriaBuilder.lessThanOrEqualTo(root.get("timestamp"), timestamp));
                    } else if (key.endsWith("eq")) {
                        criteria.add(criteriaBuilder.equal(root.get("timestamp"), timestamp));
                    }
                }

                if (key.equals("employer")) {
                    criteria.add(criteriaBuilder.equal(root.get("employer"), value));
                }

                if (key.equals("location")) {
                    criteria.add(criteriaBuilder.equal(root.get("location"), value));
                }

                if (key.equals("job_title")) {
                    criteria.add(criteriaBuilder.equal(root.get("jobTitle"), value));
                }

                if (key.startsWith("years_at_employer")) {
                    Integer yearsAtEmployer = Integer.valueOf(value);
                    if (key.endsWith("gte")) {
                        criteria.add(criteriaBuilder.greaterThanOrEqualTo(root.get("yearsAtEmployer"), yearsAtEmployer));
                    } else if (key.endsWith("lte")) {
                        criteria.add(criteriaBuilder.lessThanOrEqualTo(root.get("yearsAtEmployer"), yearsAtEmployer));
                    } else if (key.endsWith("eq")) {
                        criteria.add(criteriaBuilder.equal(root.get("yearsAtEmployer"), yearsAtEmployer));
                    }
                }

                if (key.startsWith("years_of_experience")) {
                    Integer yearsOfExperience = Integer.valueOf(value);
                    if (key.endsWith("gte")) {
                        criteria.add(criteriaBuilder.greaterThanOrEqualTo(root.get("yearsOfExperience"), yearsOfExperience));
                    } else if (key.endsWith("lte")) {
                        criteria.add(criteriaBuilder.lessThanOrEqualTo(root.get("yearsOfExperience"), yearsOfExperience));
                    } else if (key.endsWith("eq")) {
                        criteria.add(criteriaBuilder.equal(root.get("yearsOfExperience"), yearsOfExperience));
                    }
                }

                if (key.startsWith("salary")) {
                    Integer salary = Integer.valueOf(value);
                    if (key.endsWith("gte")) {
                        criteria.add(criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), salary));
                    } else if (key.endsWith("lte")) {
                        criteria.add(criteriaBuilder.lessThanOrEqualTo(root.get("salary"), salary));
                    } else if (key.endsWith("eq")) {
                        criteria.add(criteriaBuilder.equal(root.get("salary"), salary));
                    }
                }

                if (key.startsWith("signing_bonus")) {
                    Integer signingBonus = Integer.valueOf(value);
                    if (key.endsWith("gte")) {
                        criteria.add(criteriaBuilder.greaterThanOrEqualTo(root.get("signingBonus"), signingBonus));
                    } else if (key.endsWith("lte")) {
                        criteria.add(criteriaBuilder.lessThanOrEqualTo(root.get("signingBonus"), signingBonus));
                    } else if (key.endsWith("eq")) {
                        criteria.add(criteriaBuilder.equal(root.get("signingBonus"), signingBonus));
                    }
                }

                if (key.startsWith("annual_bonus")) {
                    Integer annualBonus = Integer.valueOf(value);
                    if (key.endsWith("gte")) {
                        criteria.add(criteriaBuilder.greaterThanOrEqualTo(root.get("annualBonus"), annualBonus));
                    } else if (key.endsWith("lte")) {
                        criteria.add(criteriaBuilder.lessThanOrEqualTo(root.get("annualBonus"), annualBonus));
                    } else if (key.endsWith("eq")) {
                        criteria.add(criteriaBuilder.equal(root.get("annualBonus"), annualBonus));
                    }
                }

                if (key.startsWith("annual_stock_value_bonus")) {
                    Integer annualStockValueBonus = Integer.valueOf(value);
                    if (key.endsWith("gte")) {
                        criteria.add(criteriaBuilder.greaterThanOrEqualTo(root.get("annualStockValueBonus"), annualStockValueBonus));
                    } else if (key.endsWith("lte")) {
                        criteria.add(criteriaBuilder.lessThanOrEqualTo(root.get("annualStockValueBonus"), annualStockValueBonus));
                    } else if (key.endsWith("eq")) {
                        criteria.add(criteriaBuilder.equal(root.get("annualStockValueBonus"), annualStockValueBonus));
                    }
                }

                if (key.equals("gender")) {
                    criteria.add(criteriaBuilder.equal(root.get("gender"), value));
                }

                if (key.equals("additionalComments")) {
                    criteria.add(criteriaBuilder.equal(root.get("additionalComments"), value));
                }


            }
        });

        return criteriaBuilder.and(criteria.toArray(new Predicate[criteria.size()]));
    }
}
