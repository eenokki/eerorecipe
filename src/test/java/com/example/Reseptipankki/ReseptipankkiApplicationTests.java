package com.example.Reseptipankki;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Reseptipankki.web.RecipeController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReseptipankkiApplicationTests {

	@Autowired
	 private RecipeController reciController;
	
	//basic test for controller
	@Test
	void contextLoads() throws Exception {
		 assertThat(reciController).isNotNull();
		 }
}
