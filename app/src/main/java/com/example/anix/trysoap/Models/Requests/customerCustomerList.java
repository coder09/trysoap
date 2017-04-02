package com.example.anix.trysoap.Models.Requests;

import com.example.anix.trysoap.Models.RequestBody;
import com.example.anix.trysoap.Models.RequestEnvelope;
import com.example.anix.trysoap.Models.Responses.customerCustomerListResponse;
import com.example.anix.trysoap.Utils.MagentoApi;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.filter.Filter;

/**
 * Created by anix on 26/10/16.
 */
@Root(name = customerCustomerList.ROOT_NAME,strict = false)
public class customerCustomerList {

	public static final String ROOT_NAME = "n0:customerCustomerList";
	@Element(required = false)
	private String sessionId;
	@Element(required = false)
	private Filter filters;

	public customerCustomerList(String sessionId) {
		this.setSessionId(sessionId);
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Filter getFilters() {
		return filters;
	}

	public void setFilters(Filter filters) {
		this.filters = filters;
	}

	public void requestCustomerList(MagentoApi api) {
//        CatalogProductList catalogProductList = new CatalogProductList(new LoginResponse().getLoginReturn(), "default");
		RequestBody body = new RequestBody();
		body.setCustomerListRequest(this);
		RequestEnvelope requestEnvelope = new RequestEnvelope(body);

		api.requestCustomerListOp(requestEnvelope, new customerCustomerListResponse());
	}
}
