package com.academico.application.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginViewModel {

	private String grantType;
	private String clientId;
    private String username;
    private String password;
    @JsonProperty("access_token")
	private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;

	public String getGrantType() {
        return this.grantType;
    }
    public String getClientId() {
        return this.clientId;
    }
	public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
	public String getAccessToken() {
        return this.accessToken;
    }
    public String getRefreshToken() {
        return this.refreshToken;
    }
	public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
	public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
	public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}