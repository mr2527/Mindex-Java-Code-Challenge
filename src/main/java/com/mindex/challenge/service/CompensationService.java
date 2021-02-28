package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

/**
 * Interface for CompensationService
 *
 * @author Miguel Rosario
 * <p>
 * Create two new Compensation REST endpoints. One to create and one to read by employeeId.
 */
public interface CompensationService {

    Compensation create(Compensation compensation);

    Compensation read(String employeeId);

}