package com.example.oenologie.Fragments.Fragments_Seances;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oenologie.ConnexionTomcat.AsyncResponse;
import com.example.oenologie.ConnexionTomcat.RecupererJson;
import com.example.oenologie.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Seance_3 extends Fragment implements AsyncResponse{
    private TextView tvfrags3;
    private TextView tvfrags32;
    private TextView tvfrags33;
    private String url = "http://10.34.170.211/php/seance1";

    public Fragment_Seance_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_seance_3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvfrags3 = view.findViewById(R.id.tvfrags3);
        tvfrags32 = view.findViewById(R.id.tvfrags32);
        tvfrags33 = view.findViewById(R.id.tvfrags33);
        RecupererJson recupererJson = new RecupererJson();
        recupererJson.delegate = this;
        recupererJson.execute(url);
    }


    @Override
    public void processFinish(String output) throws JSONException {
        JSONObject mainObject = new JSONObject(output);
        JSONArray mainArray = mainObject.getJSONArray("server_response");
        JSONObject unicObject = mainArray.getJSONObject(0);
        tvfrags3.setText(unicObject.getString("Date"));
        tvfrags32.setText(unicObject.getString("libelle"));
        tvfrags33.setText(unicObject.getString("Infos"));    }
}
