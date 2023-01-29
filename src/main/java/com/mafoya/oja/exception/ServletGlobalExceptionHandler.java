package com.mafoya.oja.exception;


import com.mafoya.oja.problem.DetailProblem;
import com.mafoya.oja.problem.InvalidField;
import com.mafoya.oja.problem.InvalidFieldsProblem;
import org.slf4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonMap;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public final class ServletGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = getLogger(ServletGlobalExceptionHandler.class);

	private static final String INTERNAL_SERVER_ERROR_MESSAGE = "Something went Wrong";

	private static final String MESSAGE_NOT_READABLE_ERROR_MESSAGE = "Unable to deserialize the payload";

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		LOGGER.error("bean validation failed", ex);
		List<InvalidField> invalidFields = ex.getBindingResult().getAllErrors().stream()
				.map(err -> new InvalidField(((FieldError) err).getField(), err.getDefaultMessage()))
				.collect(Collectors.toList());
		InvalidFieldsProblem problem = new InvalidFieldsProblem(BAD_REQUEST.getReasonPhrase(), BAD_REQUEST.value(),
				invalidFields);
		return status(BAD_REQUEST).header(CONTENT_TYPE, APPLICATION_PROBLEM_JSON.toString())
				.body(singletonMap("error", problem));

	}

	private static ResponseEntity<Object> createProblemDetail(HttpStatus status, Exception exception) {
		return createProblemDetail(status, exception.getMessage());
	}

	private static ResponseEntity<Object> createProblemDetail(HttpStatus status, String message) {
		DetailProblem problem = new DetailProblem(status.getReasonPhrase(), status.value(), message);
		return status(status).header(CONTENT_TYPE, APPLICATION_PROBLEM_JSON.toString())
				.body(singletonMap("error", problem));
	}

	public ResponseEntity<Object> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		LOGGER.error(String.format("Missing Request parameter [%s]", ex.getMessage()), ex);
		return createProblemDetail(BAD_REQUEST, ex);
	}

	public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		LOGGER.error(String.format(" [%s] %s - %s", NOT_FOUND.value(), NOT_FOUND.getReasonPhrase(), ex.getMessage()),
				ex);
		return createProblemDetail(NOT_FOUND, ex);
	}

	public ResponseEntity<Object> handleHttpMessageNotReadableExceptions(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error(String.format("UnCaught Exception message not readable", ex.getMessage()), ex);
		return createProblemDetail(BAD_REQUEST, MESSAGE_NOT_READABLE_ERROR_MESSAGE);
	}

	public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error(UNSUPPORTED_MEDIA_TYPE.getReasonPhrase(), exception);
		return createProblemDetail(UNSUPPORTED_MEDIA_TYPE, exception.getMessage());
	}

	public ResponseEntity<Object> handleTypeMismatchException(TypeMismatchException exception, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		LOGGER.error("Invalid Request parameter [%s]", exception.getMessage(), exception);
		return createProblemDetail(BAD_REQUEST, exception);
	}
	
	public ResponseEntity<Object> handleInternalException(Exception exception, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		if(exception instanceof HttpRequestMethodNotSupportedException) {
			return createProblemDetail(BAD_REQUEST, exception); 
		}
		LOGGER.error("Invalid Request parameter [%s]", exception.getMessage(), exception);
		return super.handleExceptionInternal(exception, body, headers, status, request);
	}
	

	@ResponseBody
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
		LOGGER.error("UnCaught Exception", exception.getMessage());
		return createProblemDetail(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE);

	}

	@ResponseBody
	@ExceptionHandler(value = TooManyRequestsException.class)
	public ResponseEntity<Object> handleTooManyRequestsException(TooManyRequestsException exception) {
		LOGGER.error(TOO_MANY_REQUESTS.getReasonPhrase(), exception);
		return createProblemDetail(TOO_MANY_REQUESTS, exception.getMessage());

	}

	@ResponseBody
	@ExceptionHandler(value = ForbiddenException.class)
	public ResponseEntity<Object> handleForbiddenException(ForbiddenException exception) {
		LOGGER.error(FORBIDDEN.getReasonPhrase(), exception);
		return createProblemDetail(FORBIDDEN, exception.getMessage());

	}

	@ResponseBody
	@ExceptionHandler(value = UnauthorizedException.class)
	public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException exception) {
		LOGGER.error(UNAUTHORIZED.getReasonPhrase(), exception);
		return createProblemDetail(UNAUTHORIZED, exception.getMessage());

	}

	@ResponseBody
	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException exception) {
		LOGGER.error(NOT_FOUND.getReasonPhrase(), exception);
		return createProblemDetail(NOT_FOUND, exception.getMessage());

	}

	@ResponseBody
	@ExceptionHandler(value = DuplicateException.class)
	public ResponseEntity<Object> handleDuplicateException(DuplicateException exception) {
		LOGGER.error(CONFLICT.getReasonPhrase(), exception);
		return createProblemDetail(CONFLICT, exception.getMessage());

	}

}
