package com.example.rgr.controllers;

import com.example.rgr.model.entity.Cinema;
import com.example.rgr.model.entity.Movie;
import com.example.rgr.model.repository.CustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/custom")
@RequiredArgsConstructor
public class CustomConsultController {

    private final CustomRepository service;

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Movie>> findCustomMoviesByCity(@PathVariable Integer id) {
        Collection<Movie> collection = service.findCustomMoviesByCity(id);
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/cinemas/{id}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Cinema>> findCustomCinemasByCity(@PathVariable Integer id) {
        Collection<Cinema> collection = service.findCustomCinemasByCity(id);
        return ResponseEntity.ok().body(collection);
    }

}
