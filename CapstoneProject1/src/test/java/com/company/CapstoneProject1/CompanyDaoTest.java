package com.company.CapstoneProject1;

import com.company.CapstoneProject1.dao.CompanyRepository;
import com.company.CapstoneProject1.dto.Company;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.Before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTest {

    @Autowired
    CompanyRepository companyRepo;

    Company company1;
    Company company2;
    Company company3;

    @Before
    public void setup() {
        companyRepo.deleteAll();

        company1 = new Company("Ball");
        company1.setCompanyName("Ball");

        company2 = new Company("Disney");
        company2.setCompanyName("Disney");

        company3 = new Company("Hogan");
        company3.setCompanyName("Hogan");
}


@Test
@Transactional
public void shouldAddCompany() {
    companyRepo.save(company1);
    companyRepo.save(company2);
    companyRepo.save(company3);

    assertNotNull(company1.getCompanyName());
    assertNotNull(company2.getCompanyName());
    assertNotNull(company3.getCompanyName());

    }

    @After
    public void tearDown() {
        companyRepo.deleteAll();
    }

    }