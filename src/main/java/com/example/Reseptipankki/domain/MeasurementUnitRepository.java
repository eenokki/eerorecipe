package com.example.Reseptipankki.domain;

import org.springframework.data.repository.CrudRepository;


//Repository for measurement unit
public interface MeasurementUnitRepository extends CrudRepository<MeasurementUnit, Long> {
	
	//List<Ingredient> findByUnit(String unit);

}