package com.example.anix.trysoap.Models.Responses;

import android.util.Log;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by anix on 15/10/16.
 */
@Root(name = CatalogProductListResponse.ROOT_NAME, strict = false)
public class CatalogProductListResponse implements Callback<CatalogProductListResponse> {
	public static final String ROOT_NAME = "n0:cataloProductListResponse";

	@Path("Body/cataloProductListResponse")
	@Element(name = "storeView", required = false)
	private CatalogProductListArray storeView;

	@Path("Body/Fault/Code")
	@Element(name = "Value", required = false)
	private String errorCode;

	@Path("Body/Fault/Reason")
	@Element(name = "Text", required = false)
	private String errorText;

	@Override
	public void success(CatalogProductListResponse catalogProductListResponse, Response response) {
		try {
			if (!catalogProductListResponse.errorCode.isEmpty() && !catalogProductListResponse.errorText.isEmpty()) {
				Log.e(TAG, "ProductListResponse Api error: " + catalogProductListResponse.errorCode + "\n -> " + catalogProductListResponse.errorText);
			} else {
				Log.i(TAG, "success: " + catalogProductListResponse.storeView);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void failure(RetrofitError error) {
		Log.e(TAG, "failure: " + error.getMessage());
	}

	@Root(name = "catalogProductListArray", strict = false)
	private class CatalogProductListArray {
		@ElementList(inline = true, entry = "item", required = false)
		private List<CatalogProductListEntity> productEntity;
	}

	private class CatalogProductListEntity {
//	    private String product_id
	}
}
