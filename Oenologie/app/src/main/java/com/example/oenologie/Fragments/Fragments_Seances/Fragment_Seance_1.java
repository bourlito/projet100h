package com.example.oenologie.Fragments.Fragments_Seances;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.oenologie.ConnexionTomcat.AsyncResponse;
import com.example.oenologie.ConnexionTomcat.RecupererJson;
import com.example.oenologie.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Seance_1 extends Fragment implements AsyncResponse{
    private TextView tvfrags1;
    private TextView tvfrags12;
    private TextView tvfrags13;
    private String url = "https://thomas-chevalier.fr/android/seance1.php";

    public Fragment_Seance_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_seance_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvfrags1 = view.findViewById(R.id.tvfrags1);
        RecupererJson recupererJson = new RecupererJson();
        recupererJson.delegate = this;
        recupererJson.execute("http://192.168.0.27/test/seance1.php");


        tvfrags1 = view.findViewById(R.id.tvfrags1);;
        tvfrags12 = view.findViewById(R.id.tvfrags12);
        tvfrags13 = view.findViewById(R.id.tvfrags13);
        recupererJson.delegate = this;
        recupererJson.execute(url);

    }


    @Override
    public void processFinish(String output) throws JSONException {
        JSONObject mainObject = new JSONObject(output);
        JSONArray mainArray = mainObject.getJSONArray("server_response");
        JSONObject unicObject = mainArray.getJSONObject(0);
        tvfrags1.setText(unicObject.getString("Date"));
        tvfrags12.setText(unicObject.getString("libelle"));
        tvfrags13.setText(unicObject.getString("Infos"));
    }
}