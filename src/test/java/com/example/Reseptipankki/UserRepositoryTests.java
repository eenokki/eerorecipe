package com.example.Reseptipankki;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Reseptipankki.domain.User;
import com.example.Reseptipankki.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	 private UserRepository repository;
	
	
	//test to see if you can find users
    @Test
    @Order(1)
    public void findByemailShouldReturnUser() {
        User users = repository.findByUsername("admin");
        assertThat(users.getUsername()).isEqualTo("admin");
    }
    
    //test to see if you can create users
    @Test
    @Order(2)
    public void createNewUser() {
    	//User(String username, String passwordHash, String email, String role)
    	User user = new User("appuser", "$2a$10$VZD8fMtBiE.f1T4viVb.NeSnxKdG9MyrpPRvWHKeyUDSMg.ZU3l3K",
    			"user@user.fi", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }    
    
    //test to see if you can delete users
    @Test
    @Order(3)
    public void deleteUser() {
    	 User user = repository.findByUsername("user");
		repository.delete(user);
		
		 User newUser = repository.findByUsername("user");
		assertThat(newUser).isEqualTo(null);
     }

}