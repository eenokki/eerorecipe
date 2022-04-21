package com.example.Reseptipankki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Reseptipankki.domain.User;
import com.example.Reseptipankki.domain.UserRepository;
import com.example.Reseptipankki.domain.IngredientRepository;
import com.example.Reseptipankki.domain.MeasurementUnit;
import com.example.Reseptipankki.domain.MeasurementUnitRepository;
import com.example.Reseptipankki.domain.Recipe;
import com.example.Reseptipankki.domain.RecipeRepository;
import com.example.Reseptipankki.domain.TipRepository;

@SpringBootApplication
public class ReseptipankkiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReseptipankkiApplication.class, args);
	}

	
	@Autowired
	private RecipeRepository reciRepository;
	
	@Autowired
	private IngredientRepository ingrRepository;
	
	@Autowired
	private TipRepository tipRepository;
	
	@Autowired
	private MeasurementUnitRepository measRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//commandlinerunner for some data to be already in the database
	@Bean
	public CommandLineRunner demo() {return (args) -> {
		
		// Recipe(String name, String url, String description, String instruction)
		Recipe a = new Recipe("Sima", "https://www.valio.fi/reseptit/sima/","Siman valmistus on loistava tapa laskeutua kevään hauskimman juhlan, vapun tunnelmaan.","Kiehauta puolet vedestä. Laita sokerit ja pestyt, viipaloidut sitruunat isoon (väh. 6 l) kattilaan tai sankoon." );
		reciRepository.save(a);		 
				
		Recipe b = new Recipe("Munkit", "https://www.valio.fi/reseptit/munkit/", "Munkit kuuluvat olennaisesti vappuun.", "Sekoita hiiva kädenlämpöiseen maitoon. Lisää munat, sokeri, mausteet ja osa jauhoista. Sekoita munkkitaikina tasaiseksi. ");
		reciRepository.save(b);
		
		// MeasurementUnit( String unit)
		MeasurementUnit meas1 = new MeasurementUnit("dl");
		measRepository.save(meas1);
		
		MeasurementUnit meas2 = new MeasurementUnit("L");
		measRepository.save(meas2);
		
		MeasurementUnit meas3 = new MeasurementUnit("g");
		measRepository.save(meas3);
		
		MeasurementUnit meas4 = new MeasurementUnit("Kg");
		measRepository.save(meas4);
		
		MeasurementUnit meas5 = new MeasurementUnit("teelusikka");
		measRepository.save(meas5);
		
		MeasurementUnit meas6 = new MeasurementUnit("ruokalusikka");
		measRepository.save(meas6);
		
		
				//pass:user, rounds 10
				User user1 = new User("user",
				"$2a$10$VZD8fMtBiE.f1T4viVb.NeSnxKdG9MyrpPRvWHKeyUDSMg.ZU3l3K","user@user.com" ,"USER");
					userRepository.save(user1);
				
				//pass:admin, rounds 10
				User user2 = new User("admin",
				"$2a$10$3pWlcjIGDG1nqbDJlmsmXOBIhbKrGr3DYILkLGfKcLF4UYbi3RuAq","admin@admin.com", "ADMIN");				
					userRepository.save(user2);
	};		
	}
}
