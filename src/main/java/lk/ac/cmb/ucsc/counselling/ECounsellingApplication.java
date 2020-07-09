package lk.ac.cmb.ucsc.counselling;

import org.springframework.boot.SpringApplication;
import lk.ac.cmb.ucsc.counselling.util.ActiveUsers;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECounsellingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECounsellingApplication.class, args);
	}

	@Bean
	public ActiveUsers activeUsersStore(){
		return new ActiveUsers();
	}

}
