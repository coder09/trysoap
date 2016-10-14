package com.example.anix.trysoap.Utils;


/**
 * Created by anix on 9/10/16.
 */

import com.example.anix.trysoap.Models.RequestEnvelope;
import com.example.anix.trysoap.Models.Responses.LoginResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface MagentoApi {

/*
    @POST("/api/v2_soap")
    void requestCatalogProductListOp(@Body RequestEnvelope body, Callback<CatalogProductListResponse> cb);
    */

    @Headers({
            "Content-Type: application/soap+xml",
            "Accept-Charset: utf-8"
    })

    @POST("/api/v2_soap")
    void requestLoginOp(@Body RequestEnvelope body, Callback<LoginResponse> cb);

}
