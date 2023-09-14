package com.br.agrotechapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config.properties")
public class AgrotechapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgrotechapiApplication.class, args);
	}

}
