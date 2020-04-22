package com.free.agendae;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.free.agendae.model.User;
import com.free.agendae.repository.UserRepository;

@SpringBootApplication
public class AgendaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaeApplication.class, args);
	}
	
	  @Bean
	    CommandLineRunner init(UserRepository repository) {
	        return args -> {
	            repository.deleteAll();
	            LongStream.range(1, 11)
	                    .mapToObj(i -> {
	                        User u = new User();
	                        u.setCpf(Long.toString(i)+ "009901");
	                        u.setName("contact" + i + "@email.com");
	                        u.setWhatsappNumber("(111) 111-1111");
	                        return u;
	                    })
	                    .map(v -> repository.save(v))
	                    .forEach(System.out::println);
	        };
	    }

}
