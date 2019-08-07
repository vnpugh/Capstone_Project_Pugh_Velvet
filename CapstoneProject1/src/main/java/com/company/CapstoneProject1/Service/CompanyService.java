package com.company.CapstoneProject1.Service;
import com.company.CapstoneProject1.dao.CompanyRepository;
import com.company.CapstoneProject1.dto.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyService {

    @Autowired
    private static CompanyRepository companyRepo;

    public CompanyService(CompanyRepository companyRepoMock) {
    }

    public Company getCompanyByCompanyId(Integer companyId) {

            return companyRepo.getOne(companyId);
    }

    public List<Company> getAllCompanies() {
            return companyRepo.findAll();
    }

    public static List<Company> getCompanyByCompanyName(String companyName) {
            return companyRepo.findCompanyByCompanyName(companyName);
    }

    public List <Company> getCompanyByFloor(Integer floor) {
            return companyRepo.findCompanyByFloor(floor);
    }

    public void updateCompany(Company company, Integer companyId) {
        if (company.getCompanyId() != companyId) {
            throw new IllegalArgumentException("Company ID must match the ID provided");
        }
        companyRepo.save(company);
    }


        public Company addCompany (Company company){
            return companyRepo.save(company);
        }


        public void deleteCompany (Integer companyId){

            companyRepo.deleteById(companyId);
        }
    }
