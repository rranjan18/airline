package com.ranjan.airline.config;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.ranjan.airline.exception.FlightsNotFoundException;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -98918549993979594L;
	@Value("${jwt.secret}")
	private String secret;

	public void validateToken(HttpHeaders headers) throws AirlineRuntimeException {

		// Dummy JWT Check
		List<String> authHeaders = headers.get("authorization");
		if (authHeaders.size() == 0) {
			throw new FlightsNotFoundException("Please pass authorization token in header");
		}
		for (String string : authHeaders) {
			if (!secret.equals(string)) {

				throw new FlightsNotFoundException("INVALID TOKEN");

			}

		}

	}
}
