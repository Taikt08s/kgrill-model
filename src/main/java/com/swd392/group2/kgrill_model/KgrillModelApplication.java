package com.swd392.group2.kgrill_model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KgrillModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(KgrillModelApplication.class, args);
	}

}
