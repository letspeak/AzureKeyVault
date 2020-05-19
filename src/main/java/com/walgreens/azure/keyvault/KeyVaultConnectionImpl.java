package com.walgreens.azure.keyvault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsoft.azure.keyvault.KeyVaultClient;
import com.walgreens.azure.keyvault.intf.KeyVaultConnectionInterface;

@Component
public class KeyVaultConnectionImpl implements KeyVaultConnectionInterface {
	
	@Autowired
	private KeyVaultConnectionCredential KeyVaultConnectionCredential;

	@Override
	public String readKeys(String key) {

		KeyVaultClient client = new KeyVaultClient(KeyVaultConnectionCredential);
		return client.getSecret(KeyVaultConnectionCredential.getKeyVaultURL(), key).value();
	}
	
	

}
