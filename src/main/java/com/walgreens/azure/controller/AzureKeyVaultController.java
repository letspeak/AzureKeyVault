package com.walgreens.azure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walgreens.azure.keyvault.intf.KeyVaultConnectionInterface;

@RestController
public class AzureKeyVaultController {
	
	@Autowired
	private KeyVaultConnectionInterface keyVaultConnectionInterface;
	
	@GetMapping(path = "readkey",headers = "content-type=*/*" )
	public String getKeySecret(@RequestParam(value = "key", defaultValue = "username") String key) {
		return keyVaultConnectionInterface.readKeys(key);
	}


}
