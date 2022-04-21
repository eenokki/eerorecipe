package com.example.Reseptipankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tip {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String note;
	
	//many to one connection to recipe class
	@ManyToOne
	@JoinColumn(name = "recipe")
	private Recipe recipe;

	//constructor
	public Tip(long id, String note) {
		this.id = id;
		this.note = note;
	}
	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
