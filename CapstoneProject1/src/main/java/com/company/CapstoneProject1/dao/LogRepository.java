package com.company.CapstoneProject1.dao;
import com.company.CapstoneProject1.dto.Company;
import com.company.CapstoneProject1.dto.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Company, Integer> {

    List<Log> getLogByCompanyId(Integer companyId);
    List<Log> getLogByEmployeeId(Integer employeeId);
    List<Log> getLogByCompanyName(String companyName);



}
