package com.example.anix.trysoap.Models;

import com.squareup.okhttp.MediaType;

import org.simpleframework.xml.Element;

import java.io.IOException;

import okio.BufferedSink;

/**
 * Created by anix on 9/10/16.
 */
//@Root(name = "n0:Body", strict = false)

public class RequestBody extends com.squareup.okhttp.RequestBody {

    @Element(name = "n0:login", required = false)
    private Object object;

    public RequestBody() {
    }

    public RequestBody(Object obj) {
        this.setObject(obj);
    }

    @Override
    public MediaType contentType() {
        return null;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
