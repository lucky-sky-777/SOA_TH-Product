package com.thienbao.soa_th_product.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthService {

	private final RestClient restClient;

	public AuthService() {
		this.restClient = RestClient.builder()
				.baseUrl("http://localhost:9090")
				.build();
	}

	public boolean validate(String token) {
		try {
			restClient.get()
					.uri("/api/auth/validate")
					.header("Authorization", token)
					.retrieve()
					.toBodilessEntity();

			return true;
		} catch (Exception e) {
			return false;
		}
	}
}