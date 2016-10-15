package com.example.anix.trysoap.Models.Requests;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by anix on 9/10/16.
 */

@Root(name = Login.ROOT_NAME, strict = false)
public class Login {
    public static final String ROOT_NAME = "n0:login";

    @Element(required = false)
    private static final String username = "androidDev";

    @Element(required = false)
    private static final String apiKey = "androidapikey";

    public Login() {

    }
}

