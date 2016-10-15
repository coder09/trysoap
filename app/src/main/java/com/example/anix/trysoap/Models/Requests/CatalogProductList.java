package com.example.anix.trysoap.Models.Requests;

import com.example.anix.trysoap.Models.RequestBody;
import com.example.anix.trysoap.Models.RequestEnvelope;
import com.example.anix.trysoap.Models.Responses.CatalogProductListResponse;
import com.example.anix.trysoap.Utils.MagentoApi;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by anix on 15/10/16.
 */
@Root(name = CatalogProductList.ROOT_NAME, strict = false)
public class CatalogProductList {
	public static final String ROOT_NAME = "n0:catalogProductList";

	@Element(required = false)
	private String sessionId;
	//    @Element(required = false)
//    Filter filters;
	@Element(required = false)
	private String storeView;

	public CatalogProductList(String sessionId, String storeView) {
		this.setSessionId(sessionId);
		this.setStoreView(storeView);
	}

	public CatalogProductList() {

	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getStoreView() {
		return storeView;
	}

	public void setStoreView(String storeView) {
		this.storeView = storeView;
	}

	public void requestProductList(MagentoApi api) {
//        CatalogProductList catalogProductList = new CatalogProductList(new LoginResponse().getLoginReturn(), "default");
		RequestBody body = new RequestBody();
		body.setCatalogProductList(this);
		RequestEnvelope requestEnvelope = new RequestEnvelope(body);

		api.requestProductListOp(requestEnvelope, new CatalogProductListResponse());
	}

}
