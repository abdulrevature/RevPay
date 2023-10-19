package com.revature.SpringWithLambda.models;

//This DTO will send back the username or the user that logged in, as well as the JWT accessToken
public class AuthResponseDTO {

    private String username;
    private String accessToken;

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(String username, String accessToken) {
        this.username = username;
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "AuthResponseDTO{" +
                "username='" + username + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}