package br.com.pilares.ancontabil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AncontabilApplication {

	public static void main(String[] args) {
		SpringApplication.run(AncontabilApplication.class, args);
	}

}
