package com.backend.webExplora;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebExploraApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(WebExploraApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(WebExploraApplication.class, args);
		LOGGER.info("WebExploraApplication se está ejecutando...");
	}

	@Bean
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}
}
