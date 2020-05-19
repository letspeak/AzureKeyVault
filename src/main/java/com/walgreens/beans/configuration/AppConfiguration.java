package com.walgreens.beans.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.walgreens.azure.keyvault.KeyVaultConnectionCredential;
import com.walgreens.azure.keyvault.KeyVaultConnectionImpl;
import com.walgreens.azure.keyvault.intf.KeyVaultConnectionInterface;

@Configuration
@ComponentScan(basePackages = {"com.walgreens.azure"})
public class AppConfiguration {

	@Bean
	public KeyVaultConnectionInterface keyVaultConnectionInterface() {
		return new KeyVaultConnectionImpl();
	}

	@Bean
	public KeyVaultConnectionCredential keyVaultConnectionCredential() {
		return new KeyVaultConnectionCredential();
	}

}
