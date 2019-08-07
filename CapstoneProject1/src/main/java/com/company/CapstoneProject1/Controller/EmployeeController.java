package com.company.CapstoneProject1.Controller;

import com.company.CapstoneProject1.dto.Employee;
import com.company.CapstoneProject1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value ="/{lastName}")
    public List<Employee> getEmployeeByLastName(@PathVariable String lastName) {
        return employeeService.getEmployeeByLastName(lastName);
    }

    @GetMapping(value ="{employeeId}")
    public Employee getEmployeeByEmployeeId(@PathVariable Integer employeeId) {
            return employeeService.getEmployeeByEmployeeId(employeeId);
        }

    @GetMapping(value ="/{companyName}")
    public Employee getEmployeeByCompanyName(@PathVariable String companyName) {
        return employeeService.getEmployeeByCompanyName(companyName);
    }


    @PostMapping
    public Employee addEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping(value ="/{employeeId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateEmployee(@RequestBody @Valid Employee employee, @PathVariable Integer employeeId) {
        employeeService.updateEmployee(employee, employeeId);
    }

    @DeleteMapping(value ="/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}










































