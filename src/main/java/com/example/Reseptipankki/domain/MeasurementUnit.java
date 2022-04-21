package com.example.Reseptipankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MeasurementUnit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String unit;
	
	/*
	@OneToMany
	@JoinColumn(name = "ingredient")
	private Ingredient ingredient;
	*/
	
	//constructors
	public MeasurementUnit() {}
	
	public MeasurementUnit( String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "MeasurementUnit [unit="+unit+"]";
	}
	
	//getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
