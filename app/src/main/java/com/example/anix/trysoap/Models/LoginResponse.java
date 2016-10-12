package com.example.anix.trysoap.Models;

/**
 * Created by anix on 9/10/16.
 */

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = LoginResponse.ROOT_NAME, strict = false)
public class LoginResponse {
    public static final String ROOT_NAME = "n0:loginResponse";

    @Path("Body/loginResponse")
    @Element(required = false)
    private String loginReturn;

    @Element(name = "Value", required = false)
    @Path("Body/Fault/Code")
    private String errorCode;

    @Element(name = "Text", required = false)
    @Path("Body/Fault/Reason")
    private String errorText;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getLoginReturn() {
        return loginReturn;
    }

    public void setLoginReturn(String loginReturn) {
        this.loginReturn = loginReturn;
    }
}
