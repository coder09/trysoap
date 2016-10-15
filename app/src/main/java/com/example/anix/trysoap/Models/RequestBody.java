package com.example.anix.trysoap.Models;

import com.example.anix.trysoap.Models.Requests.CatalogProductList;
import com.example.anix.trysoap.Models.Requests.Login;
import com.squareup.okhttp.MediaType;

import org.simpleframework.xml.Element;

import java.io.IOException;

import okio.BufferedSink;

/**
 * Created by anix on 9/10/16.
 */
//@Root(name = "n0:Body", strict = false)

public class RequestBody extends com.squareup.okhttp.RequestBody {

	@Element(name = Login.ROOT_NAME, required = false)
	private Login login;
	@Element(name = CatalogProductList.ROOT_NAME, required = false)
	private CatalogProductList catalogProductList;

	public RequestBody() {
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public CatalogProductList getCatalogProductList() {
		return catalogProductList;
	}

	public void setCatalogProductList(CatalogProductList catalogProductList) {
		this.catalogProductList = catalogProductList;
	}

	@Override
	public MediaType contentType() {
		return null;
	}

	@Override
	public void writeTo(BufferedSink sink) throws IOException {

	}

}
