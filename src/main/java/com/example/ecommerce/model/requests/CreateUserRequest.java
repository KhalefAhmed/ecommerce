package com.example.ecommerce.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class CreateUserRequest {

	@NotEmpty(message = "Username must not be null or blank.")
	@JsonProperty
	private String username;

	@NotEmpty(message = "itemId must not be null or blank.")
	@Positive(message = "itemId must be greater than 0")
	@JsonProperty
	private String password;

	@NotEmpty(message = "quantity must not be null or blank.")
	@Positive(message = "quantity must be greater than 0")
	@JsonProperty
	private String confirmPassword;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmePassword) {
		this.confirmPassword = confirmePassword;
	}
}
