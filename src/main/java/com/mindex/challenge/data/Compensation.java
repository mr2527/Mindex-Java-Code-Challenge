package com.mindex.challenge.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * General class required to create a Compensation object.
 * As instructed, requires 3 params:
 * A Compensation has the following fields: employee, salary, and effectiveDate
 *
 * @author Miguel Rosario
 */
public class Compensation {

    //Required employee, salary, effectiveDate
    private Employee employee;
    private double salary;
    private String effectiveDate;

    /**
     * Constructor
     *
     * @param employee      employee
     * @param salary        salary
     * @param effectiveDate effective date
     */
    public Compensation(Employee employee, double salary, String effectiveDate) {

        this.effectiveDate = effectiveDate;
        this.employee = employee;
        this.salary = salary;

    }

    /**
     * Getter for employee
     *
     * @return employee
     */
    public Employee getEmployee() {

        return employee;

    }

    /**
     * Getter for salary
     *
     * @return salary
     */
    public double getSalary() {

        return salary;

    }

    /**
     * Getter for Effective date
     *
     * @return effective date
     */
    public String getEffectiveDate() {

        return effectiveDate;

    }

    /**
     * Setter for Employee
     *
     * @param employee Employee
     */
    public void setEmployee(Employee employee) {

        this.employee = employee;

    }

    /**
     * Setter for Salary
     *
     * @param salary Salary
     */
    public void setSalary(double salary) {

        this.salary = salary;

    }

    /**
     * setter for Effective Date,
     * Creates a date object with the util import,
     * then is formatted by DateFormat,
     * then parsed into effective date.
     */
    public void setEffectiveDate() {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        this.effectiveDate = dateFormat.format(date);

    }
}
