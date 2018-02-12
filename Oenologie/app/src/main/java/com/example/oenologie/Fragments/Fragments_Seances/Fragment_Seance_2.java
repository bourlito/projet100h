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
public class Fragment_Seance_2 extends Fragment implements AsyncResponse{
    private TextView tvfrags2;
    private TextView tvfrags22;
    private TextView tvfrags23;
    private String url = "https://thomas-chevalier.fr/android/seance2.php";

    public Fragment_Seance_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_seance_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvfrags2 = view.findViewById(R.id.tvfrags2);
        tvfrags22 = view.findViewById(R.id.tvfrags22);
        tvfrags23 = view.findViewById(R.id.tvfrags23);
        RecupererJson recupererJson = new RecupererJson();
        recupererJson.delegate = this;
        recupererJson.execute(url);
    }

    @Override
    public void processFinish(String output) throws JSONException{
        JSONObject mainObject = new JSONObject(output);
        JSONArray mainArray = mainObject.getJSONArray("server_response");
        JSONObject unicObject = mainArray.getJSONObject(0);
        tvfrags2.setText(unicObject.getString("Date"));
        tvfrags22.setText(unicObject.getString("Libelle"));
        tvfrags23.setText(unicObject.getString("Informations"));}
}
