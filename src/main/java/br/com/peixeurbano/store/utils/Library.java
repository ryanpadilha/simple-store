package br.com.peixeurbano.store.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * Library utility class
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class Library {

	private Library() {

	}

	public static UUID transformToUUID(String value) {
		UUID result = UUID.fromString(value);
		return result;
	}

	public static String getClientIP(HttpServletRequest request) {
		String xfHeader = request.getHeader("X-Forwarded-For");
		if (xfHeader == null) {
			return request.getRemoteAddr();
		}
		return xfHeader.split(",")[0];
	}
}
