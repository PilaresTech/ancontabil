package br.com.pilares.ancontabil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableFeignClients
@SpringBootApplication
public class AncontabilApplication {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("asdasd123"));
		SpringApplication.run(AncontabilApplication.class, args);
	}

}
