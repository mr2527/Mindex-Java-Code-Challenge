package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class that allows for URL routing to localhost:8080/compensation/{id}
 * as instructed
 *
 * @author Miguel Rosario
 */
@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    /**
     * Required for grabbing compensation
     */
    @Autowired
    private CompensationService compensationService;

    /**
     * Read method created for receiving the request
     * with employeeID
     * @param id employeeID
     * @return Compensation.read
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id){

        // Logger for appropriate messages
        LOG.debug("COMPCONTROLLER: Received compensation read request with ID: [{}]", id);
        return compensationService.read(id);

    }

    /**
     * create method constructed to allow for receiving create responses
     * and sending a compensation.
     * @param compensation compensation
     * @return compensationService.create
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation){

        // Logger for appropriate messages
        LOG.debug("COMPCONTROLLER: Received compensation create request with ID: [{}]", compensation);
        return compensationService.create(compensation);

    }

}
