package com.mafoya.oja.problem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({ "type", "title", "status" })
public class DetailProblem extends Problem {

	@JsonProperty
	private String detail;

	public DetailProblem(@JsonProperty("title") String title, int status, @JsonProperty("detail") String detail) {
		super("https://localhost/details", title, status);
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}

}
