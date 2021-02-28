package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Service class created to allow for Compensation to be processed.
 * Construction of two methods, create and read
 *
 * @author Miguel Rosario
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    // Logger for appropriate messages
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    // Wiring for usage
    @Autowired
    private CompensationRepository compensationRepository;

    // Wiring for usage
    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * create method constructed to allow for the creation or updating of
     * compensation entries
     *
     * @param compensation compensation
     * @return compensation
     */
    @Override
    public Compensation create(Compensation compensation) {

        LOG.debug("Creating or updating compensation [{}]", compensation);

        Compensation compensation1 =
                compensationRepository.findByEmployeeEmployeeId(compensation.getEmployee().getEmployeeId());

        if (compensation1 != null) {

            compensationRepository.save(compensation);

        } else {

            compensationRepository.insert(compensation);

        }

        return compensation;

    }

    /**
     * read method constructed to allow for reading an employees
     * id and checking for validity along with any previous compensation
     *
     * @param id employeeID
     * @return compensation
     */
    @Override
    public Compensation read(String id) {

        Compensation compensation;

        LOG.debug("CompServIMPL: Finding employee compensation by ID: [{}]", id);

        compensation = compensationRepository.findByEmployeeEmployeeId(id);

        if (compensation == null) {

            Employee employee = employeeRepository.findByEmployeeId(id);

            if (employee == null) {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No employee with id: '" +
                        id + "' exists.");

            } else {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: '" + id + "' exists " +
                        "but has no compensation recorded.");

            }
        }

        return compensation;

    }
}
