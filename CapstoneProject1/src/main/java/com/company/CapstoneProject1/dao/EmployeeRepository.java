package com.company.CapstoneProject1.dao;

import com.company.CapstoneProject1.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> getEmployeeByLastName(String lastName);
    List<Employee> findEmployeeByFirstName (String firstName);
    List<Employee> getEmployeeByCompanyName (String companyName);
    List<Employee> findEmployeeByEmployeeId(Integer employeeId) throws Exception;


}
