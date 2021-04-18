package com.example.rgr.controllers;

import com.example.rgr.model.entity.ComplexNumber;
import com.example.rgr.model.entity.ListComplexNumber;
import com.example.rgr.services.Questao1Service;
import com.example.rgr.services.exceptions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/questao1")
public class Questao1Controller {

    @Autowired
    private Questao1Service service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> calculeComplexNumber(@Valid @RequestBody ListComplexNumber obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        try {
            return ResponseEntity.ok().body(service.calcule(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("A requisição não foi formatada corretamente");
    }

}
