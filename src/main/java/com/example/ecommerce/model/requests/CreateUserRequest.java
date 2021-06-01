package com.example.ecommerce.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class CreateUserRequest {

	@NotEmpty(message = "Username must not be null or blank.")
	@JsonProperty
	private String username;

	@NotEmpty(message = "password must not be null or blank.")
	@JsonProperty
	private String password;

	@NotEmpty(message = "confirmPassword must not be null or blank.")
	@JsonProperty
	private String confirmPassword;

	@Override
	public String toString() {
		return "CreateUserRequest{" +
				"username='" + username + '\'' +
				'}';
	}

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
