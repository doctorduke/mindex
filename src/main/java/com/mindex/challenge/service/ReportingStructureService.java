package com.mindex.challenge.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.ReportingStructure;

@RestController
public interface ReportingStructureService {
    
    ReportingStructure createReport(@PathVariable String employeeId);
}
