package com.thienbao.soa_th_product.auth.config;

import com.thienbao.soa_th_product.auth.filter.AuthFilter;
import com.thienbao.soa_th_product.auth.service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

//	@Bean
//	public AuthFilter authFilter(AuthService authService) {
//		return new AuthFilter(authService);
//	}

	@Bean
	SecurityFilterChain securityFilterChain(
			HttpSecurity http,
			AuthFilter authFilter
	) throws Exception {

		return http
				.csrf(csrf -> csrf.disable())

				.sessionManagement(session ->
						session.sessionCreationPolicy(
								SessionCreationPolicy.STATELESS
						)
				)

				.authorizeHttpRequests(auth ->
						auth.anyRequest().authenticated()
				)

				.addFilterBefore(
						authFilter,
						UsernamePasswordAuthenticationFilter.class
				)

				.build();
	}
}