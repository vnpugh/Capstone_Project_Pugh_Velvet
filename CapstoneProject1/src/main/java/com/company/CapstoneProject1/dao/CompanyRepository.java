package com.company.CapstoneProject1.dao;

import com.company.CapstoneProject1.dto.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

        List<Company> findCompanyByCompanyName(String companyName);
        List<Company> findCompanyByFloor(Integer floor);
        List<Company> findCompanyByCompanyId(Integer companyId);


}





