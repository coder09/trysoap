package com.example.anix.trysoap.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by anix on 9/10/16.
 */

@Root(name = "soap12:Envelope")

@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://www.w3.org/2003/05/soap-envelope", prefix = "soap12"),
        @Namespace(reference = "urn:Magento", prefix = "n0")

})

public class RequestEnvelope {
    @Element(name = "soap12:Body")
    private RequestBody body;

    public RequestEnvelope(RequestBody body) {
        this.setBody(body);
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }
}

