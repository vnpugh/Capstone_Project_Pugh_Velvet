package com.company.CapstoneProject1;

import com.company.CapstoneProject1.Service.CompanyService;
import com.company.CapstoneProject1.dao.CompanyRepository;
import com.company.CapstoneProject1.dto.Company;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {  //testing find by company name
    @Mock
    CompanyRepository companyRepoMock;

    @InjectMocks
    CompanyService companyService = new CompanyService(companyRepoMock);

    Company company1;
    Company company2;
    Company company3;

    List<Company> companyList;

    @Before
    public void setup() {
        company1 = new Company("Ball");
        company2 = new Company("Stark");
        company3 = new Company("Disney");

        companyList = Arrays.asList(company1,company2,company3);
    }

@Test
    public void testCompaniesFromCompanyList() {
        List<Company> expectedList = Arrays.asList(company1, company2);
        when(companyRepoMock.findCompanyByCompanyName("Ball")).thenReturn(expectedList);
        assertEquals(expectedList, companyService.getCompanyByCompanyName("Bal"));
}

}
