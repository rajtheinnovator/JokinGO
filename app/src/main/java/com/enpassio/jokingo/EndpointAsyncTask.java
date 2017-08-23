package com.enpassio.jokingo;

import android.content.Context;
import android.os.AsyncTask;

import com.enpassio.jokingo.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * code below referenced from the
 * link: https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */

public class EndpointAsyncTask extends AsyncTask<EndpointAsyncTask.OnEventListener, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private OnEventListener onEventListener;

    @Override
    protected String doInBackground(OnEventListener... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://noted-throne-177719.appspot.com/_ah/api/");
            // end options for devappserver


            myApiService = builder.build();
        }
        onEventListener = params[0];
        try {
            return myApiService.sayAJoke("name").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //referenced from: https://stackoverflow.com/a/16327968/5770629

        onEventListener.onEvent(result);
    }


    public interface OnEventListener {
        void onEvent(String joke);
        // or void onEvent(); as per your need
    }
}