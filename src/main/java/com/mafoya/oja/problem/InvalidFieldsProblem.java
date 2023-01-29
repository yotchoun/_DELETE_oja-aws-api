package com.mafoya.oja.problem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class InvalidFieldsProblem extends Problem {

	@JsonProperty
	private List<InvalidField> invalidFields;

	@JsonCreator
	public InvalidFieldsProblem(@JsonProperty("title") String title, @JsonProperty("status") int status,
			@JsonProperty("invalidFields") List<InvalidField> invalidFields) {
		super("http//localhost/probs/validation-error", title, status);
		this.invalidFields = Collections.unmodifiableList(invalidFields);
	}

	public List<InvalidField> getInvalidFields() {
		return invalidFields;
	}

}
