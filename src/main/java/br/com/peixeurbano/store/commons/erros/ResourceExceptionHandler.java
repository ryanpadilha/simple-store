package br.com.peixeurbano.store.commons.erros;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.BadRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.peixeurbano.store.exceptions.BadCredentialsException;
import br.com.peixeurbano.store.exceptions.NotFoundEntityException;
import br.com.peixeurbano.store.exceptions.RelationshipNotFoundException;
import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.to.BaseObject;

/**
 * The resource error handler for {@link MethodArgumentNotValidException}
 *
 * For error handling the HTTP Status code in the 4xx range indicate client-side
 * errors (validation or logic errors).<br>
 * While those in the 5xx range indicate server-side erros (usually detect or
 * outage). For machine-readable manner, we need additional help with more
 * information.
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceExceptionHandler.class);

	private MessageSource messageSource;

	@Autowired
	public ResourceExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ValidationError> handleGenericException(Exception e, WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.UNKNOWN_ERROR);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
		return new ResponseEntity<ValidationError>(validationError, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ValidationError> handleDataIntegrityViolation(DataIntegrityViolationException e,
			WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		String[] messages = e.getMostSpecificCause().getMessage().split("\\n");

		final ValidationError validationError = ValidationError.buildResponse(TypeError.DATA_INTEGRITY_ERROR);
		validationError.addFieldError(e.getClass().getSimpleName(), messages[0].replaceAll("\"", "'"));
		return new ResponseEntity<ValidationError>(validationError, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvocationTargetException.class)
	public ResponseEntity<ValidationError> handleInvocationTarget(InvocationTargetException e, WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.VALIDATION_ERROR);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
		return new ResponseEntity<ValidationError>(validationError, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundEntityException.class)
	public ResponseEntity<Object> handleNotFoundEntity(NotFoundEntityException e, WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - returning empty object - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final BaseObject responseBody = new BaseObject();
		return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e,
			WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final BaseObject responseBody = new BaseObject();
		return new ResponseEntity<>(responseBody, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException e, WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final BaseObject responseBody = new BaseObject();
		return new ResponseEntity<>(responseBody, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UniqueConstraintException.class)
	public ResponseEntity<ValidationError> handleUniqueConstraint(UniqueConstraintException e, WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.VALIDATION_ERROR);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
		return new ResponseEntity<ValidationError>(validationError, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RelationshipNotFoundException.class)
	public ResponseEntity<ValidationError> handleRelationshipNotFound(RelationshipNotFoundException e,
			WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.VALIDATION_ERROR);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
		return new ResponseEntity<ValidationError>(validationError, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ValidationError> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
			WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.METHOD_NOT_ALLOWED);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
		return new ResponseEntity<ValidationError>(validationError, headers, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ValidationError> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException e,
			WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.UNSUPPORTED_MEDIA_TYPE);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
		return new ResponseEntity<ValidationError>(validationError, headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

//	@ExceptionHandler(LockedException.class)
//	public ResponseEntity<ValidationError> handleLockedUser(LockedException e, WebRequest request) {
//		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);
//
//		final HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//
//		final ValidationError validationError = ValidationError.buildResponse(TypeError.LOCKED_USER);
//		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
//		return new ResponseEntity<>(validationError, headers, HttpStatus.UNAUTHORIZED);
//	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ValidationError> handleBadCredentials(BadCredentialsException e, WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.BAD_CREDENTIALS_ERROR);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
		return new ResponseEntity<>(validationError, headers, HttpStatus.UNAUTHORIZED);
	}

//	@ExceptionHandler(org.springframework.security.authentication.BadCredentialsException.class)
//	public ResponseEntity<ValidationError> handleBadCredentials(
//			org.springframework.security.authentication.BadCredentialsException e, WebRequest request) {
//		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);
//
//		final HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//
//		final ValidationError validationError = ValidationError.buildResponse(TypeError.BAD_CREDENTIALS_ERROR);
//		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
//		return new ResponseEntity<>(validationError, headers, HttpStatus.UNAUTHORIZED);
//	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ValidationError> handleBadRequest(BadRequestException e, WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.BAD_REQUEST_ERROR);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMessage()); // e.getLocalizedMessage()
		return new ResponseEntity<>(validationError, headers, HttpStatus.BAD_REQUEST);
	}

	/**
	 * When {@code @RequestBody} is null.<br>
	 * Translate exception from {@code RequestResponseBodyMethodProcessor}.
	 *
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ValidationError> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
			WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + " - Request: " + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = ValidationError.buildResponse(TypeError.BAD_REQUEST_ERROR);
		validationError.addFieldError(e.getClass().getSimpleName(), e.getMostSpecificCause().getMessage());
		return new ResponseEntity<>(validationError, headers, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			WebRequest request) {
		LOGGER.info(e.getClass().getSimpleName() + "- MethodArgumentNotValidException - Request:" + request);

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		final ValidationError validationError = this.processFieldErrors(e.getBindingResult());
		return new ResponseEntity<ValidationError>(validationError, headers, HttpStatus.BAD_REQUEST);
	}

	private ValidationError processFieldErrors(BindingResult binding) {
		final ValidationError validationError = ValidationError.buildResponse(TypeError.REQUIRED_DATA_ERROR);

		for (FieldError fieldError : binding.getFieldErrors()) {
			// fieldError.getObjectName() + "." + fieldError.getField()
			validationError.addFieldError(fieldError.getCode(), this.resolveLocalizedErrorMessage(fieldError));
		}

		return validationError;
	}

	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		return messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
	}
}
