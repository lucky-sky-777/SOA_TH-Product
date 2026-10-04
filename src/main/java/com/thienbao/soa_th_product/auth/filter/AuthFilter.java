package com.thienbao.soa_th_product.auth.filter;

import com.thienbao.soa_th_product.auth.service.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class AuthFilter extends OncePerRequestFilter {

	private final AuthService authService;

	public AuthFilter(AuthService authService) {
		this.authService = authService;
	}

	@NullMarked
	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain
	) throws ServletException, IOException {

		System.out.println("filter");

		String token = request.getHeader("Authorization");

		if (token == null || !token.startsWith("Bearer ")) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		System.out.println("after bear");

		if (!authService.validate(token)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		System.out.println("after vali");

		var authentication =
				new UsernamePasswordAuthenticationToken(
						"user",
						null,
						List.of()
				);

		SecurityContextHolder.getContext()
				.setAuthentication(authentication);

		filterChain.doFilter(request, response);
	}
}