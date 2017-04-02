package com.example.anix.trysoap.Utils;


/**
 * Created by anix on 9/10/16.
 */

import com.example.anix.trysoap.Models.RequestEnvelope;
import com.example.anix.trysoap.Models.Responses.CatalogProductListResponse;
import com.example.anix.trysoap.Models.Responses.LoginResponse;
import com.example.anix.trysoap.Models.Responses.customerCustomerListResponse;

import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface MagentoApi {
    @Headers({
            "Content-Type: application/soap+xml",
            "Accept-Charset: utf-8"
    })

    @POST("/api/v2_soap")
    void requestLoginOp(@Body RequestEnvelope requestEnvelope, LoginResponse loginResponse);

	@POST("/api/v2_soap")
	void requestProductListOp(@Body RequestEnvelope requestEnvelope, CatalogProductListResponse catalogProductListResponse);

	@POST("/api/v2_soap")
	void requestCustomerListOp(@Body RequestEnvelope requestEnvelope, customerCustomerListResponse customerListResponse);
}
