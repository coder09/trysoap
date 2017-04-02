package com.example.anix.trysoap.Utils;

import android.content.Context;
import android.content.res.Resources;

import com.example.anix.trysoap.R;
import com.squareup.okhttp.OkHttpClient;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by anix on 27/11/16.
 */

public class GetApi {

	private static final String MAGENTO_URL = "http://onebagfull.com/anish/index.php";

	private retrofit.RestAdapter getRestAdapter() {
		String endpoint = GetApi.MAGENTO_URL;
		Strategy strategy = new AnnotationStrategy();
		Serializer serializer = new Persister(strategy);
		OkHttpClient okHttpClient = new OkHttpClient();

		return new RestAdapter.Builder()
				.setEndpoint(endpoint)
				.setClient(new OkClient(okHttpClient))
				.setConverter(new SimpleXMLConverter(serializer))
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.build();
	}

	public MagentoApi getMagentoApiObject() {
		RestAdapter restAdapter = this.getRestAdapter();
		return restAdapter.create(MagentoApi.class);
	}

}
