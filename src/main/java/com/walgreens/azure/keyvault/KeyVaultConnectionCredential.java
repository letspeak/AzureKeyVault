package com.walgreens.azure.keyvault;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.ClientCredential;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.azure.keyvault.authentication.KeyVaultCredentials;

@Component
public class KeyVaultConnectionCredential extends KeyVaultCredentials {

	@Value("${azure.keyvault.url}")
	private String keyVaultURL;
	
	@Value("${azure.keyvault.clientid}")
	private String clientID;

	@Value("${azure.keyvault.clientsecret}")
	private String clientSecret;

	
	public String getKeyVaultURL() {
		return keyVaultURL;
	}

	public KeyVaultConnectionCredential() {
//		this.clientID = clientID;
//		this.clientSecret = clientSecret;
		System.out.println(clientID+"  "+clientSecret);
	}

	@Override
	public String doAuthenticate(String authorization, String resource, String scope) {
		AuthenticationResult token = getAccessTokenFromClientCredentials(authorization, resource, clientID,
				clientSecret);
		return token.getAccessToken();

	}

	private static AuthenticationResult getAccessTokenFromClientCredentials(String authorization, String resource,
			String clientId, String clientKey) {
		AuthenticationContext context = null;
		AuthenticationResult result = null;
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(1);
			context = new AuthenticationContext(authorization, false, service);
			ClientCredential credentials = new ClientCredential(clientId, clientKey);
			Future<AuthenticationResult> future = context.acquireToken(resource, credentials, null);
			result = future.get();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			service.shutdown();
		}
		if (result == null)
			throw new RuntimeException("authentication failed");

		return result;
	}
}
