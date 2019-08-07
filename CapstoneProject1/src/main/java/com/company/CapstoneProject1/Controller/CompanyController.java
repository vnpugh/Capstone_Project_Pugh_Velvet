package com.company.CapstoneProject1.Controller;

import com.company.CapstoneProject1.dto.Company;
import com.company.CapstoneProject1.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping // GET all companies
    public List<Company> getAllCompanies() {
        return service.getAllCompanies();
    }

    @GetMapping(value ="/{companyId}") // GET by companyId;
    public Company getCompanyById(@PathVariable int companyId) {
        return service.getCompanyByCompanyId(companyId);
    }

    @GetMapping(value ="/{companyName") // GET by companyName;
    public List<Company> getCompanyByCompanyName(@PathVariable String companyName) {
        return service.getCompanyByCompanyName(companyName);
    }

    @GetMapping(value ="/{floor}")
    public List<Company> getCompanyByFloor(@PathVariable Integer floor) {
        return service.getCompanyByFloor(floor);
    }

    @PutMapping(value ="/{companyId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCompany(@RequestBody @Valid Company company, @PathVariable Integer companyId) {
        service.updateCompany(company, companyId);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Company addCompany(@RequestBody @Valid Company company) {
        return service.addCompany(company);
    }

    @DeleteMapping(value ="/{companyId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int companyId) {
        service.deleteCompany(companyId);
    }
}





















