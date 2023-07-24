package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
    @Autowired
    EmployeeService  employeeService;

    @Override
    @GetMapping("/reporting-structure/{employeeId}")
    public ReportingStructure createReport(@PathVariable String employeeId){
        LOG.debug("Creating employee report with id [{}]", employeeId);
        Employee employee = employeeService.read(employeeId);
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId:" + employeeId);
        }
        ReportingStructure rs =  new ReportingStructure(employee);
        return rs;
    }
}
