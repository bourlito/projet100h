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

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Seance_2 extends Fragment implements AsyncResponse{
    private TextView tvfrags2;

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
        RecupererJson recupererJson = new RecupererJson();
        recupererJson.delegate = this;
        recupererJson.execute("http://192.168.0.34/php/seance2");
    }

    @Override
    public void processFinish(String output) {
        tvfrags2.setText(output);
    }
}
