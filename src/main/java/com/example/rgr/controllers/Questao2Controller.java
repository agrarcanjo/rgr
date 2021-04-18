package com.example.rgr.controllers;


import com.example.rgr.model.entity.ListName;
import com.example.rgr.model.entity.Name;
import com.example.rgr.services.Questao2Service;
import com.example.rgr.services.exceptions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/questao2")
public class Questao2Controller {

    @Autowired
    private Questao2Service service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ListName> calculeComplexNumber(@Valid @RequestBody ListName listName, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());

        // String[] lista = {"Pedro", "João", "Maria", "JOAO", "Alberto", "João", "MARiA"};

        try {
            return ResponseEntity.ok().body(service.order(listName));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new ListName());
        }
    }

}
