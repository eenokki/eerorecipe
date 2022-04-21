package com.example.Reseptipankki.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//repository for tips
public interface TipRepository extends CrudRepository<Tip, Long> {
	
	//List<Tip> findByNote(String note);

} 