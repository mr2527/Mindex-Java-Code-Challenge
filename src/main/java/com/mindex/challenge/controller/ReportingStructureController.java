package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Generally took how EmployeeController is created and decomposed it to
 * figure out how to structure ReportingStructureController
 * <p>
 * Class that allows for URL routing to localhost:8080/reportingStrcture/{id}
 * as instructed
 *
 * @author Miguel Rosario
 */
@RestController
public class ReportingStructureController {

    // Logger for appropriate messages
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    /**
     * Required for grabbing Struct
     */
    @Autowired
    private ReportingStructureService reportingStructureService;


    /**
     * Create mapping to the instructed URL with a variable to read in.
     * Created Logger for appropriate messages
     *
     * @param id employeeID
     * @return Report from the created getReportingStruct(id) method
     */
    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure read(@PathVariable String id) {

        // Logger for appropriate messages
        LOG.debug("Received reporting structure request for id [{}]", id);
        return reportingStructureService.getReportingStruct(id);

    }
}
