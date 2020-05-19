package com.walgreens.azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.walgreens.azure")
public class AzureKeyVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureKeyVaultApplication.class, args);
	}

}
