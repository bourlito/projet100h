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
import com.example.oenologie.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by etienne on 05/12/2017.
 */


public class RecupererJson extends AsyncTask<Void, Void, String> {
    String JSON_URL;

    String JSON_STRING;

    Context context;

    public RecupererJson(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    protected void onPreExecute() {
        JSON_URL = "http://192.168.0.27/test/seance1.php";
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            StringBuilder JSON_DATA = new StringBuilder();
            URL url = new URL(JSON_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream in = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((JSON_STRING = reader.readLine()) != null) {
                JSON_DATA.append(JSON_STRING).append("\n");
            }
            return JSON_DATA.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON_STRING;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String JSON_STRING) {
        Intent intent = new Intent(context,Fragment_Seance_1.class);
        Bundle bundle = new Bundle();
        bundle.putString("json",JSON_STRING);
        intent.putExtras(bundle);
        Fragment_Seance_1 fragment_seance_1 = new Fragment_Seance_1();
        fragment_seance_1.setArguments(bundle);
        fragment_seance_1.startActivity(intent);
    }

}