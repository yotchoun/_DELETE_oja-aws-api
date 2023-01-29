package com.mafoya.oja.problem;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Problem {

	@JsonProperty
	private String type;

	@JsonProperty
	private String title;

	@JsonProperty
	private int status;

	protected Problem(String type, String title, int status) {
		this.type = type;
		this.title = title;
		this.status = status;
	}

	public String type() {
		return type;
	}

	public String title() {
		return title;
	}

	public int status() {
		return status;
	}

}
