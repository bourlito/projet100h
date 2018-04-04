package com.example.oenologie.Fragments.Fragments_Seances;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oenologie.ConnexionTomcat.AsyncResponse;
import com.example.oenologie.ConnexionTomcat.Parsing;
import com.example.oenologie.ConnexionTomcat.RecupererJson;
import com.example.oenologie.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Seance_1 extends Fragment implements AsyncResponse{
    private TextView tvfrags1;
    private TextView tvfrags12;
    private TextView tvfrags13;
    private String url = "https://thomas-chevalier.fr/android/seance1.php";

    private int a=0;
    private String dateparse;
    private JSONObject mainObject;
    private JSONArray mainArray;
    private JSONObject unicObject;

    private DateFormat inputformat;
    private DateFormat outputformat;
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
        tvfrags12 = view.findViewById(R.id.tvfrags12);
        tvfrags13 = view.findViewById(R.id.tvfrags13);

        //recuperation du json
        RecupererJson recupererJson = new RecupererJson();
        //buffer pour ne pas recharger le json a chaque retour sur l'activite
        recupererJson.delegate = this;
        recupererJson.execute(url);
    }

    @Override
    public void processFinish(String output) throws JSONException, ParseException {
        Parsing parsing = new Parsing();
        ArrayList<String> elements = parsing.parseSeance(output);

        tvfrags1.setText(elements.get(0));
        tvfrags12.setText(elements.get(1));
        tvfrags13.setText(elements.get(2));
    }
}