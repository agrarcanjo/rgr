package com.example.rgr.services;

import com.example.rgr.model.entity.City;
import com.example.rgr.model.repository.CityRepository;
import com.example.rgr.services.exceptions.DataIntegrityException;
import com.example.rgr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public City findById(Integer id) {
    	try {
            City obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + City.class.getName());
        }
    }

    public City insert(City obj) {
        obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Cidade não foi(foram) preenchido(s): UF");
        }
    }

    public Collection<City> findAll() {
        return repository.findAll();
    }
}
