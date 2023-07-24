package com.mindex.challenge;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;

@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        InputStream inputStream = this.getClass().getResourceAsStream(DATASTORE_LOCATION);

        Employee[] employees = null;
        Compensation[] compensations = null;

        try {
            employees = objectMapper.readValue(inputStream, Employee[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Employee employee : employees) {
            employeeRepository.insert(employee);
        }

        // try {
        //     compensations = objectMapper.readValue(inputStream, Compensation[].class);
        // } catch (IOException e) {
        //     throw new RuntimeException(e);
        // }
        // for (Compensation compensation : compensations) {
        //     compensationRepository.insert(compensation);
        // }

    }
}
