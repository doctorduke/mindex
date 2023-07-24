package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;
    @Autowired
    private EmployeeService employeeService;

    
    @GetMapping("/compensation/{employeeId}")
    public Compensation read(@PathVariable String employeeId) {
        LOG.debug("Received employee create request for id [{}]", employeeId);

        return compensationService.read(employeeId);
    }

    @PutMapping("/compensation/{employeeId}")
    public Compensation update(@PathVariable String employeeId, @RequestBody Compensation compensation) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", employeeId, compensation);
        Compensation comp = compensationService.read(employeeId);
        Employee employee = employeeService.read(employeeId);
        compensation.setEmployee(employee);
        return compensationService.update(compensation);
    }
}
