package com.example.rgr.controllers;

import com.example.rgr.model.entity.City;
import com.example.rgr.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<City>> findAll() {
        Collection<City> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> find(@PathVariable Integer id) {
        City obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
