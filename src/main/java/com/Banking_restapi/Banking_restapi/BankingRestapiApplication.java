package com.Banking_restapi.Banking_restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BankingRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingRestapiApplication.class, args);
		System.out.println("hello project bank");
	}

}
