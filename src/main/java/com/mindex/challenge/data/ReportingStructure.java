package com.mindex.challenge.data;

/**
 * General class required to create a Reporting structure
 * As instructed, requires 2 params, employee and numberOfReports
 *
 * @author Miguel Rosario
 */
public class ReportingStructure {

    //required properties
    private Employee employee;
    private int numOfReports;

    /**
     * constructor
     *
     * @param employee     employee object
     * @param numOfReports number of reports
     */
    public ReportingStructure(Employee employee, int numOfReports) {

        this.employee = employee;
        this.numOfReports = numOfReports;

    }

    /**
     * setter for employee
     *
     * @param employee employee object
     */
    public void setEmployee(Employee employee) {

        this.employee = employee;

    }

    /**
     * setter for Number of reports
     *
     * @param numOfReports number of reports
     */
    public void setNumOfReports(int numOfReports) {

        this.numOfReports = numOfReports;

    }

    /**
     * getter for employee
     *
     * @return employee
     */
    public Employee getEmployee() {

        return employee;

    }

    /**
     * getting for number of reports
     *
     * @return int - number of reports
     */
    public int getNumOfReports() {

        return numOfReports;

    }
}
