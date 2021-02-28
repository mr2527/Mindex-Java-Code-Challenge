package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

/**
 * Duplicate code for create and read from EmployeeServiceImpl
 * but going for single responsibility & appropriate class structure
 *
 * @author Miguel Rosario
 */
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    // Logger for appropriate messages
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    // Wiring for usage
    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * create method constructed to allow for inserting employees into the
     * repo, copied from EmployeeServiceImpl.java
     *
     * @param employee employee
     * @return employee
     */
    @Override
    public Employee create(Employee employee) {

        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;

    }

    /**
     * read method constructed to allow for reading employees
     * ids. Checks for validity and returns an employee if found
     *
     * @param id employeeID
     * @return employee
     */
    @Override
    public Employee read(String id) {

        LOG.debug("Creating employee with id [{}]", id);
        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No employee with id: '" +
                    id + "' exists.");

        }

        return employee;

    }

    @Override
    /*
      Required method for getting the reporting structure count
     */
    public ReportingStructure getReportingStruct(String id) {

        //Get the employees ID and create a queue then add that employee
        Employee employee = read(id);

        Queue<Employee> employeeQueue = new LinkedList<>();
        employeeQueue.add(employee);

        int eCount = 0;

        // Check if the method is empty, if not go through do-while and while not empty
        // add employee to poll and check if that employee has a report, if yes
        // go through entire report and grab data.
        // return the entire report and count of reports.

        // The numberOfReports for employee John Lennon (employeeId: 16a596ae-edd3-4847-99fe-c4518e82c86f)
        // would be equal to 4.
        //
        // This new type should have a new REST endpoint created for it.
        // ***(see ReportingStructureController.java)***
        //
        // This new endpoint should accept an employeeId and return the fully
        // filled out ReportingStructure for the specified employeeId.
        // The values should be computed on the fly and will not be persisted.
        if (!employeeQueue.isEmpty()) {

            do {

                Employee employee2 = employeeQueue.poll();

                if (employee2.getDirectReports() != null) {

                    List<Employee> directReports = employee2.getDirectReports();

                    for (Employee employeeReport : directReports) {

                        employeeQueue.add(read(employeeReport.getEmployeeId()));
                        eCount++;

                    }
                }

            } while (!employeeQueue.isEmpty());
        }

        return new ReportingStructure(employee, eCount);

    }
}
