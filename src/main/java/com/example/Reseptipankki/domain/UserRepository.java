package com.example.Reseptipankki.domain;

import org.springframework.data.repository.CrudRepository;

//repository for handling user data
public interface UserRepository extends CrudRepository<User, Long>{ 
	User findByUsername(String username);

		
}
