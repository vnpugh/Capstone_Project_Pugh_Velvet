package com.company.CapstoneProject1.Service;

import com.company.CapstoneProject1.dao.EmployeeRepository;
import com.company.CapstoneProject1.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public Employee getEmployeeByCompanyName(String companyName) {
        return (Employee) employeeRepo.getEmployeeByCompanyName(companyName);
    }

    public Employee getEmployeeByEmployeeId(Integer employeeId) {

        return employeeRepo.getOne(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public List<Employee> getEmployeeByLastName(String lastName) {
        return employeeRepo.getEmployeeByLastName(lastName);
    }

    public void updateEmployee(Employee employee, Integer employeeId) {
        if (employee.getEmployeeId() != employeeId) {
            throw new IllegalArgumentException("Employee ID is invalid");
        }
        employeeRepo.save(employee);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(int employeeId) {
    }


}