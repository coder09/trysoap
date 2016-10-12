package com.example.anix.trysoap.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by anix on 9/10/16.
 */

@Root(name = Login.ROOT_NAME, strict = false)
public class Login {
    public static final String ROOT_NAME = "n0:login";

    @Element(required = false)
    private String username;

    @Element(required = false)
    private String apiKey;

    public Login() {

    }

    public Login(String mUsername, String mApiKey) {
        this.setUsername(mUsername);
        this.setApiKey(mApiKey);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
