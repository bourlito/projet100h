package com.example.oenologie.ConnexionTomcat;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oenologie.Fragments.Fragment_Seance;
import com.example.oenologie.Fragments.Fragments_Seances.Fragment_Seance_1;
import com.example.oenologie.MainActivity;
import com.example.oenologie.R;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by etienne on 05/12/2017.
 */


public class RecupererJson extends AsyncTask<String, Void, String> {

    String JSON_URL = "http://192.168.0.27/test/seance1.php";
    String JSON_STRING;


    private String JSON_STRING;

    public AsyncResponse delegate = null;

    @Override
    protected String doInBackground(String... params) {
        try {
            StringBuilder JSON_DATA = new StringBuilder();
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream in = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((JSON_STRING = reader.readLine()) != null) {
                JSON_DATA.append(JSON_STRING).append("\n");
            }
            reader.close();
            in.close();
            httpURLConnection.disconnect();
            return JSON_DATA.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON_STRING;
    }

    @Override
    protected void onPostExecute(String JSON_STRING) {
        try {
            delegate.processFinish(JSON_STRING);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}