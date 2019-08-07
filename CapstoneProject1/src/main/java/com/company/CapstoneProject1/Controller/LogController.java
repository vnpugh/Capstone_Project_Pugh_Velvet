package com.company.CapstoneProject1.Controller;

import com.company.CapstoneProject1.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.company.CapstoneProject1.dto.Log;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/log")
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping(value ="/{companyId}")
    public List<Log> getLogByCompanyId(@PathVariable Integer companyId) {
        return logService.getLogByCompanyId(companyId);
    }

    @GetMapping(value ="/{employeeId}")
    public List<Log> getLogByEmployeeId(@PathVariable Integer employeeId) {
        return (List<Log>) logService.getLogByEmployeeId(employeeId);
    }

    @GetMapping(value ="/{companyName}") //Retrieve the log for a specific company
    public List<Log> getLogByCompanyName(@PathVariable String companyName) {
        return logService.getLogByCompanyName(companyName);
    }

    @PutMapping(value="/{employeeId}") // to update the log with entries & exits by employeeId
     @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void updateLog(@RequestBody @Valid Log log, @PathVariable Integer employeeId)   {
        logService.updateLog(log, employeeId);
}

}


























