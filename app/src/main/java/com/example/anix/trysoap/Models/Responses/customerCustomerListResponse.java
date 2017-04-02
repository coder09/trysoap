package com.example.anix.trysoap.Models.Responses;

import android.util.Log;

import com.example.anix.trysoap.Models.Requests.customerCustomerEntity;

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
 * Created by anix on 26/10/16.
 */
@Root(name = customerCustomerListResponse.ROOT_NAME, strict = false)
public class customerCustomerListResponse implements Callback<customerCustomerListResponse> {
	public static final String ROOT_NAME = "customerCustomerListResponse";

	@Path("Body/customerCustomerListResponse")
	@Element
	private customerCustomerListArray storeView;
	@Path("Body/Fault/Code")
	@Element(name = "Value", required = false)
	private String errorCode;
	@Path("Body/Fault/Reason")
	@Element(name = "Text", required = false)
	private String errorText;

	@Override
	public void success(customerCustomerListResponse customerCustomerListResponse, Response response) {
		try {
			if (!customerCustomerListResponse.errorCode.isEmpty() && !customerCustomerListResponse.errorText.isEmpty()) {
				Log.e(TAG, "ProductListResponse Api error: " + customerCustomerListResponse.errorCode + "\n -> " + customerCustomerListResponse.errorText);
			} else {
				Log.i(TAG, "success: " + customerCustomerListResponse.storeView);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void failure(RetrofitError error) {
		Log.e(TAG, "failure: " + error.getMessage());
	}

	public customerCustomerListArray getStoreView() {
		return storeView;
	}

	public void setStoreView(customerCustomerListArray storeView) {
		this.storeView = storeView;
	}

	@Root(name = "customerCustomerListArray", strict = false)
	private class customerCustomerListArray {
		@ElementList(inline = true, entry = "item", required = false)
		private List<customerCustomerEntity> customerEntity;
	}
}
