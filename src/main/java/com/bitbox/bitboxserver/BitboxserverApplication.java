package com.bitbox.bitboxserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableJpaRepositories("com.bitbox.bitboxserver.dao")
@SpringBootApplication
public class BitboxserverApplication {

	public static void main(String[] args) {

		SpringApplication.run(BitboxserverApplication.class, args);
	}


}
