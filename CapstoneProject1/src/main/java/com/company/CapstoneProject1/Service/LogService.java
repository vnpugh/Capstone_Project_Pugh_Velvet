package com.company.CapstoneProject1.Service;

import com.company.CapstoneProject1.dao.LogRepository;
import com.company.CapstoneProject1.dto.Company;
import com.company.CapstoneProject1.dto.Log;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Component
public class LogService {

    @Autowired
    private LogRepository logRepo;

    public Company getLogByEmployeeId(Integer employeeId) {
        return logRepo.getOne(employeeId);
    }


    public List<Log> getLogByCompanyId(Integer companyId) {
        return logRepo.getLogByCompanyId(companyId);
    }

    public List<Log> getLogByCompanyName(String companyName) {
        return logRepo.getLogByCompanyName(companyName);
    }

    public void updateLog(Log log, Integer employeeId) {
    }
}
