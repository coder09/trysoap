package com.example.anix.trysoap.Models.Responses;

/**
 * Created by anix on 9/10/16.
 */

import android.util.Log;

import com.example.anix.trysoap.Models.RequestBody;
import com.example.anix.trysoap.Models.RequestEnvelope;
import com.example.anix.trysoap.Models.Requests.Login;
import com.example.anix.trysoap.Models.Requests.customerCustomerList;
import com.example.anix.trysoap.Utils.GetApi;
import com.example.anix.trysoap.Utils.MagentoApi;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static android.content.ContentValues.TAG;

@Root(name = LoginResponse.ROOT_NAME, strict = false)
public class LoginResponse implements Callback<LoginResponse> {
	public static final String ROOT_NAME = "n0:loginResponse";

	@Path("Body/loginResponse")
	@Element(required = false)
	private static String loginReturn;

	@Element(name = "Value", required = false)
	@Path("Body/Fault/Code")
	private String errorCode;

	@Element(name = "Text", required = false)
	@Path("Body/Fault/Reason")
	private String errorText;

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public String getLoginReturn() {
		return loginReturn;
	}

	@Override
	public void success(LoginResponse loginResponse, Response response) {
		if (loginResponse.getErrorCode() != null && !loginResponse.getErrorCode().isEmpty()) {
			Log.e(TAG, "api error status code: " + loginResponse.getErrorCode() + " " + loginResponse.getErrorText());
		} else {
			Log.i(TAG, "success! " + loginResponse.getLoginReturn());
			MagentoApi api = new GetApi().getMagentoApiObject();
			customerCustomerList cuList = new customerCustomerList(this.getLoginReturn());
			cuList.requestCustomerList(api);

		}

	}

	@Override
	public void failure(RetrofitError error) {
		Log.e(TAG, "server error: " + error.toString());
	}


	public void apiLogin(MagentoApi api) {
		Login login = new Login();
		RequestBody body = new RequestBody();
		body.setLogin(login);
		RequestEnvelope request = new RequestEnvelope(body);

		api.requestLoginOp(request, new LoginResponse());
	}

}
