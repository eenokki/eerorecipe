package com.example.Reseptipankki.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "measurementUnit")
	private MeasurementUnit measurementUnit;
	
	//list of recipies based on ingredients
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
	@JsonIgnore
	private List<Recipe> recipies;
	
	//object to string method override
	@Override
	public String toString() {
		return "Ingredient [name="+name+",amount="+amount+", measurementUnit="+measurementUnit+"]";
	}
	
	//constructors
	public Ingredient() {}
	
	public Ingredient(long id, String name, double amount, MeasurementUnit measurementUnit, List<Recipe> recipies) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.measurementUnit = measurementUnit;
		this.recipies = recipies;
	}
	
	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public MeasurementUnit getMeasurement() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public List<Recipe> getRecipies() {
		return recipies;
	}

	public void setRecipies(List<Recipe> recipies) {
		this.recipies = recipies;
	}

}
