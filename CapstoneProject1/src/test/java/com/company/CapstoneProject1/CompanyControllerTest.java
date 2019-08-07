package com.company.CapstoneProject1;

import antlr.build.Tool;
import com.company.CapstoneProject1.Controller.CompanyController;
import com.company.CapstoneProject1.Service.CompanyService;
import com.company.CapstoneProject1.dao.CompanyRepository;
import com.company.CapstoneProject1.dto.Company;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static javax.swing.UIManager.get;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CompanyControllerTest { //Testing GET

    @Mock
    CompanyService service;

    @InjectMocks
    CompanyController companyController;

    Company company1;
    Company company2;
    Company company3;
    List<Company> companyList;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();

        company1 = new Company("Ball");
        company1.setCompanyName("Ball");

        company2 = new Company("Disney");
        company2.setCompanyName("Disney");

        company3 = new Company("Acme");
        company3.setCompanyName("Acme");

    }

    @Test
public void ShouldReturnCompanyByCompanyName() throws Exception{
        companyList = Arrays.asList(company2);
        when(CompanyService.getCompanyByCompanyName(companyList.get(0).getCompanyName())).thenReturn
                (companyList);

        mockMvc.perform((RequestBuilder) get("/company/companyName/" + companyList.get(0).getCompanyName()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect((ResultMatcher) jsonPath("$[0].companyName", is(companyList.get(0).getCompanyName())))  ;

        verify(companyController).getCompanyByCompanyName(companyList.get(0).getCompanyName());



    }
}



