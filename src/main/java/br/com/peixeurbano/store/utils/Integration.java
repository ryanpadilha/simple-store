package br.com.peixeurbano.store.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Integration utility class
 *
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class Integration {

	private Integration() {

	}

	public static Map<String, String> buildMessageAPI(boolean success, String status, String statusCode,
			String message) {
		final Map<String, String> buildMessage = new HashMap<>();
		buildMessage.put("success", Boolean.toString(success));
		buildMessage.put("status", status);
		buildMessage.put("status_code", statusCode);
		buildMessage.put("message", message);
		return buildMessage;
	}
}
