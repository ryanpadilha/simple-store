package br.com.peixeurbano.store.commons.erros;

/**
 * The Type Error enumeration used on {@link ValidationError}
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public enum TypeError {

	// @formatter:off
	BAD_REQUEST_ERROR(400, "Bad request error"), 
	METHOD_NOT_ALLOWED(405, "Request method not supported"),
	UNSUPPORTED_MEDIA_TYPE(415, "Media type is not supported"), 
	INTERNAL_SERVER_ERROR(500, "Unexpected server error"),
	UNKNOWN_ERROR(500, "Error not yet mapped"), 
	VALIDATION_ERROR(400, "Invalid data provided"),
	AUTHENTICATION_REQUIRED_ERROR(401, "Authentication Credentials is not valid"),
	BAD_CREDENTIALS_ERROR(401, "Bad Credentials"), 
	LOCKED_USER(401, "User is not active"),
	NOT_FOUND_RESOURCE_ERROR(404, "Resource endpoint not found"), 
	DATA_INTEGRITY_ERROR(400, "Data Integrity Violation"),
	REQUIRED_DATA_ERROR(400, "Required field is missing");
	// @formatter:on

	private int code;
	private String message;

	TypeError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
