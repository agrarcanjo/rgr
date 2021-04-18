package com.example.rgr.model.repository;

import com.example.rgr.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
