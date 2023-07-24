package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{employeeId}")
    public Employee read(@PathVariable String employeeId) {
        LOG.debug("Received employee create request for id [{}]", employeeId);

        return employeeService.read(employeeId);
    }

    @PutMapping("/employee/{employeeId}")
    public Employee update(@PathVariable String employeeId, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", employeeId, employee);

        employee.setEmployeeId(employeeId);
        return employeeService.update(employee);
    }
}
