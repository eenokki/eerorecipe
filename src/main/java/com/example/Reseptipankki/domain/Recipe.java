package com.example.Reseptipankki.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Recipe {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String url;
	private String  description;
	private String instruction;
	//private Ingredient ingredient;
	
	
	//many to one connection to tip class
	@ManyToOne
	@JoinColumn(name = "tip")
	private Tip tip;
	
	//many to one connection to ingredient class
	@ManyToOne
	@JoinColumn(name = "ingredient")
	private Ingredient ingredient;
	
	
	//constructors
	public Recipe() {}
	public Recipe(String name, String url, String description, String instruction) {
		this.name = name;
		this.url = url;
		this.description = description;
		this.instruction = instruction;
	}
	
	//override for toString method in order for object to be presentable as string
	@Override
	public String toString() {
		return "Recipe [name=" +name+ ", url=" +url+ ", description=" +description+ ", instruction=" +instruction+"]";
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
	

}
