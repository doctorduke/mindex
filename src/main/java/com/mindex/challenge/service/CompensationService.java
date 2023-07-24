package com.mindex.challenge.service;


import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensation;

@RestController
public interface CompensationService {
    Compensation create(String employeeId);
    Compensation read(String employeeId);
    Compensation update(Compensation compensation);
}
