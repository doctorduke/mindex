package com.mindex.challenge.data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Compensation {
    @Id
    String employeeId;
    Employee employee;
    int salary;
    Date effectiveDate;
    
    public Compensation() {
    }

    public String getEmployeeId() {
        if (employee == null) {
            throw new RuntimeException("No compensation filed for employee");
        }
        return this.employeeId = employee.getEmployeeId();
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Date getEffectiveDate() {
        return effectiveDate;
    }
    public void setEffectiveDate(Date date) {
        this.effectiveDate = date;
    }
}

