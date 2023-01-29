package com.mafoya.oja.problem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class InvalidParametersProblem extends Problem{
	
	@JsonProperty
	private List<InvalidField> invalidParams;

	@JsonCreator
	public InvalidParametersProblem(@JsonProperty("title") String title, @JsonProperty("status") int status,
			@JsonProperty("name") List<InvalidField> invalidParams) {
		super("http//localhost/probs/validation-error", title, status);
		this.invalidParams = Collections.unmodifiableList(invalidParams);
	}

	public List<InvalidField> getInvalidParams() {
		return invalidParams;
	}

	
}
