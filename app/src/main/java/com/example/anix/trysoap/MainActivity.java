package com.example.anix.trysoap;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.anix.trysoap.Models.Login;
import com.example.anix.trysoap.Models.LoginResponse;
import com.example.anix.trysoap.Models.RequestBody;
import com.example.anix.trysoap.Models.RequestEnvelope;
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

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    public static final String mUsername = "androidDev";
    public static final String mApiKey = "androidapikey";
    private static final String MAGENTO_URL = "http://onebagfull.com/anish/index.php";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//output callback
        Callback<LoginResponse> cb = new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse respEnv, Response response) {
                if (respEnv.getErrorCode() != null && !respEnv.getErrorCode().isEmpty()) {
                    Log.e(TAG, "api error status code: " + respEnv.getErrorCode() + " " + respEnv.getErrorText());
                } else {
                    Log.i(TAG, "success! " + respEnv.getLoginReturn());
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "server error: " + error.toString());
            }
        };

//input message
        Login login = new Login(mUsername, mApiKey);
        RequestEnvelope request = getRequestEnvelope(login);

        MagentoApi api = getMagentoApiObject();

        api.requestLoginOp(request, cb);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private MagentoApi getMagentoApiObject() {
        RestAdapter restAdapter = getRestAdapter();
        return restAdapter.create(MagentoApi.class);
    }

    @NonNull
    private RequestEnvelope getRequestEnvelope(Object obj) {
        RequestBody body = new RequestBody(obj);
        RequestEnvelope request = new RequestEnvelope(body);

        return request;
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
