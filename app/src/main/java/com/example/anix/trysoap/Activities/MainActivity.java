package com.example.anix.trysoap.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.anix.trysoap.Models.Requests.CatalogProductList;
import com.example.anix.trysoap.Models.Responses.LoginResponse;
import com.example.anix.trysoap.R;
import com.example.anix.trysoap.Utils.MagentoApi;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.okhttp.OkHttpClient;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.SimpleXMLConverter;

public class MainActivity extends AppCompatActivity {

	private static final String MAGENTO_URL = "http://onebagfull.com/anish/index.php";
	private MagentoApi api = getMagentoApiObject();
	private LoginResponse lr = new LoginResponse();
	private CatalogProductList cpl;
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;

	public static retrofit.RestAdapter getRestAdapter() {
		String endpoint = MAGENTO_URL;
		Strategy strategy = new AnnotationStrategy();
		Serializer serializer = new Persister(strategy);
		OkHttpClient okHttpClient = new OkHttpClient();
		retrofit.RestAdapter restAdapter = new retrofit.RestAdapter.Builder()
				.setEndpoint(endpoint)
				.setClient(new OkClient(okHttpClient))
				.setConverter(new SimpleXMLConverter(serializer))
				.setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
				.build();

		return restAdapter;
	}

	private MagentoApi getMagentoApiObject() {
		RestAdapter restAdapter = getRestAdapter();
		return restAdapter.create(MagentoApi.class);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lr.apiLogin(api);
		cpl = new CatalogProductList(lr.getLoginReturn());
		cpl.requestProductList(api);

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
	}

	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	public Action getIndexApiAction() {
		Thing object = new Thing.Builder()
				.setName("Main Page") // TODO: Define a title for the content shown.
				// TODO: Make sure this auto-generated URL is correct.
				.setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
				.build();
		return new Action.Builder(Action.TYPE_VIEW)
				.setObject(object)
				.setActionStatus(Action.STATUS_TYPE_COMPLETED)
				.build();
	}

	@Override
	public void onStart() {
		super.onStart();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client.connect();
		AppIndex.AppIndexApi.start(client, getIndexApiAction());
	}

	@Override
	public void onStop() {
		super.onStop();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		AppIndex.AppIndexApi.end(client, getIndexApiAction());
		client.disconnect();
	}
}
