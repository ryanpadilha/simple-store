package br.com.peixeurbano.store.commons.erros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The validation class errors handler
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class ValidationError implements Serializable {

	private static final long serialVersionUID = -1226355260558422311L;

	private TypeError name;
	private String message;
	private int statusCode;
	private Date timestamp;
	private List<IssueError> issues;

	private ValidationError() {

	}

	public static ValidationError buildResponse(TypeError type) {
		final ValidationError validationError = new ValidationError();
		validationError.setName(type);
		validationError.setMessage(type.getMessage());
		validationError.setStatusCode(type.getCode());
		validationError.setTimestamp(new Date());
		return validationError;
	}

	public void addFieldError(String issue, String message) {
		if (null == this.issues) {
			this.issues = new ArrayList<>();
		}

		this.issues.add(new IssueError(issue, message));
	}

	public TypeError getName() {
		return name;
	}

	public void setName(TypeError name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<IssueError> getIssues() {
		return issues;
	}

	public void setIssues(List<IssueError> issues) {
		this.issues = issues;
	}

	@Override
	public String toString() {
		return "ValidationError [name=" + name + ", message=" + message + ", statusCode=" + statusCode + ", timestamp="
				+ timestamp + ", issues=" + issues + "]";
	}
}
