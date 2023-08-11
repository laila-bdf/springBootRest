package com.test.app.controller;

import com.test.app.entity.MyObject;
import com.test.app.service.CsvInitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DataController {
    @Autowired
    private CsvInitializationService csvService;
    @GetMapping
    public List<MyObject> getObjects(){
        return csvService.getAll();
    }

    @PostMapping
    public String addObject(@RequestBody MyObject myObject){
        System.out.println(myObject);
        csvService.addObject(myObject);
        return "line added successfully";
    }

    @PostMapping("/generate")
    public String generateObject(){
        csvService.addRandomObject();
        return "random object added successfully";
    }
}
