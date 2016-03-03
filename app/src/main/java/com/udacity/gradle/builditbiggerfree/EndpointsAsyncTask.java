package com.udacity.gradle.builditbiggerfree;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.example.benwong.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import junit.framework.Assert;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by benwong on 2016-02-20.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    @VisibleForTesting

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")


                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

//        try {
//            return myApiService.sayHi(name).execute().getData();
//        } catch (IOException e) {
//            return e.getMessage();
//        }

        Log.i("Test connection", String.valueOf(checkConnection(3000)));

        Assert.assertEquals(checkConnection(3000),true);

        try {
            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }


    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Log.i("connection result", result);

        assert result.getClass().getName().equals(String.class);

        Log.i("Test Async Result", String.valueOf(result.getClass().getName()));

        Log.i("Test Async Result", String.valueOf(result.getClass().getName().equals(String.class.getName())));

        Assert.assertEquals(result.getClass().getName(), String.class.getName());
    }

    private boolean checkConnection(int timeout){
        try{
            URL myUrl = new URL("http://10.0.3.2:8080/_ah/api/");
            URLConnection connection = myUrl.openConnection();
            connection.setConnectTimeout(timeout);
            connection.connect();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    interface TaskFactoryInterface {
        EndpointsAsyncTask getTask();
    }

    @VisibleForTesting
    protected class TaskFactory implements  TaskFactoryInterface{
        @Override
        public EndpointsAsyncTask getTask() {
            return new EndpointsAsyncTask();
        }
    }
}
