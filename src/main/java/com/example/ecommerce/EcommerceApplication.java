package com.example.ecommerce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaRepositories("com.example.ecommerce.model.persistence.repositories")
@EntityScan("com.example.ecommerce.model.persistence")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EcommerceApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean(name="eCommerceServerUrl")
	public String eCommerceServerUrl (@Value("${server.hostname:localhost}") String host,
									  @Value("${server.port:8081}") String port) {
		return "http://" + host + ":" + port;
	}


}
