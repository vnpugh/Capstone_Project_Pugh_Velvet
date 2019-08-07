package com.company.CapstoneProject1;

import com.company.CapstoneProject1.dto.Company;
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.Before;

import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CompanyDtoTest {

    @Mock
    CompanyDtoTest companyDtoTest;
    
    private Company company1;
    private Company company2;
    private Company company3;

    @Before
    public void setUp() {
        companyDtoTest.deleteAll();

        company1 = new Company("Disney");
        company1.setCompanyName("Disney");

        company2 = new Company("Tek");
        company2.setCompanyName("Tek");
    }

    private void deleteAll() {
    }

    @Test
    @Transactional
    public void shouldDeleteCompany(){

        companyDtoTest.deleteByCompanyName(company1);
        companyDtoTest.deleteByCompanyName(company2);

        Optional<Company> fromDto = companyDtoTest.deleteByCompanyName(company1.getCompanyName());
        
        assertFalse(fromDto.isPresent());
        
    }


    private Optional<Company> deleteByCompanyName(Company companyName) {
        return null;
    }


    @After
    public void tearDown() {
        companyDtoTest.deleteAll();

    }
}


