package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

/**
 * Interface for ReportingStructureService
 *
 * @author Miguel Rosario
 * <p>
 * This new type should have a new REST endpoint created for it.
 * This new endpoint should accept an employeeId and return the
 * fully filled out ReportingStructure for the specified employeeId.
 * The values should be computed on the fly and will not be persisted.
 */
public interface ReportingStructureService {

    Employee create(Employee employee);

    Employee read(String id);

    ReportingStructure getReportingStruct(String id);

}
