package nl.dat.catfact;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * CatFactApplication is used to run a CatFactJob scheduler for every 5 minutes
 * requesting the API (https://catfact.ninja/fact)
 * 
 * @author Nisha
 *
 */
@EnableScheduling
@SpringBootApplication
public class CatFactApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatFactApplication.class, args);
	}

}
