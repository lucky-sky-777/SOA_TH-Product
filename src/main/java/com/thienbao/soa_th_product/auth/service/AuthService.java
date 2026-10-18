package com.thienbao.soa_th_product.auth.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class AuthService {

	RestClient authRestClient;

	public boolean validate(String token) {
		try {
			authRestClient.get()
					.uri("/api/auth/validate")
					.header("Authorization", token)
					.retrieve()
					.toBodilessEntity();

			return true;
		} catch (RestClientResponseException e) {
			return false;
		}
	}

}