package com.mindex.challenge.service.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;


@Service
public class CompensationServiceImpl implements CompensationService{
    @Autowired
    CompensationRepository compensationRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Compensation create(String employeeId) {
        Compensation compensation = compensationRepository.findByEmployeeId(employeeId);
        compensation.setEmployee(employeeRepository.findByEmployeeId(employeeId));
        return compensation;
    }

    private Date getRandomDate() {
        Random random = new Random();
        long randomMillis = 88888;
        return new Date(randomMillis);
    }
    
    @Override
    public Compensation read(String employeeId) {
        Compensation compensation = compensationRepository.findByEmployeeId(employeeId);
        // if (compensation == null) {
        //     throw new RuntimeException("No compensation filed for employeeId: " + employeeId);
        // }
        return compensation;
    }

    @Override
    public Compensation update(Compensation compensation) {
        String employeeId = compensation.getEmployeeId();
        Compensation comp = compensationRepository.findByEmployeeId(employeeId);
        // Employee employee = employeeRepository.findByEmployeeId(employeeId);
        // if (comp == null || employee == null) {
        //     throw new RuntimeException("No compensation filed for employeeId: " + compensation.getEmployeeId());
        // }
        comp = compensation;
        return compensationRepository.save(comp);
    }
}
