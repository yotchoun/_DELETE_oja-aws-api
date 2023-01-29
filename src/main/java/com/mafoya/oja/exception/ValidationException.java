package com.mafoya.oja.exception;

import org.springframework.validation.Errors;

class ValidationException extends RuntimeException {

	private Errors errors;

	ValidationException(Errors errors) {
		super("BeanValidation Exception");
		this.errors = errors;
	}

	Errors getErrors() {
		return errors;
	}

}
