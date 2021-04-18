package com.example.rgr.services;

import com.example.rgr.model.entity.Movie;
import com.example.rgr.model.repository.MovieRepository;
import com.example.rgr.services.exceptions.DataIntegrityException;
import com.example.rgr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Movie findById(Integer id) {
    	try {
            Movie obj = repository.findById(id).get();
        	return obj;
        } catch (NoSuchElementException e) {
        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Movie.class.getName());
        }
    }

    public Movie insert(Movie obj) {
        obj.setId(null);
        try {
        	return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo(s) obrigatório(s) da Filme não foi(foram) preenchido(s): UF");
        }
    }

    public Collection<Movie> findAll() {
        return repository.findAll();
    }
}
