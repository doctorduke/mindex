package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {
    // private String employeeId;
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(Employee employee) {
        this.employee = employee;
        this.numberOfReports = countReports(this.employee);
    }
    static private int countReports(Employee employee) {
        List<Employee> directReports = employee.getDirectReports();
        if (directReports == null) {
            return 0;
        }

        int totalReports = directReports.size();
        for (Employee report : directReports) {
            totalReports = totalReports + ReportingStructure.countReports(report);
        }
        return totalReports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

}
