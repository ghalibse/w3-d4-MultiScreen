package com.example.simpledoublefragment;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 8/4/2016.
 */
public class Networking extends AsyncTask<String, Void, String> {

    private static final String TAG = "NetworkingTAG_";
    private LeftFragment leftFragment;

    public Networking( LeftFragment leftFragment) {
        super();

        this.leftFragment = leftFragment;
    }

    @Override
    protected String doInBackground(String... strings) {

//        return "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";
        String url = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String JSONstring = response.body().string();
//            Log.d(TAG, "doMagic: " +  JSONstring);
            return JSONstring;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        leftFragment.loadJSON(s);
    }
}
