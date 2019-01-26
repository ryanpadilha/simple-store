package br.com.peixeurbano.store.commons.erros;

import java.io.Serializable;

/**
 * The field error handler
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class IssueError implements Serializable {

	private static final long serialVersionUID = -1840996873491546592L;

	private String issue;
	private String message;

	public IssueError(String issue, String message) {
		this.issue = issue;
		this.message = message;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FieldError [issue=" + issue + ", message=" + message + "]";
	}
}
