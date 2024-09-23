package com.kaz.data_brazilian_company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RegistrationDataBrazilianCitizensApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationDataBrazilianCitizensApplication.class, args);
	}

}
