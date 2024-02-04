package com.ygorftf.apicostumers.controllers;

import com.ygorftf.apicostumers.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/costumers")
public class CostumerController {
    @Autowired
    private CostumerService service;


}
