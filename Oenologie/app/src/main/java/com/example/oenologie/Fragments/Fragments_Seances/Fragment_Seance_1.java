package com.example.oenologie.Fragments.Fragments_Seances;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oenologie.ConnexionTomcat.RecupererJson;
import com.example.oenologie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Seance_1 extends Fragment {
    private TextView tvfrags1;

    public Fragment_Seance_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecupererJson recupererJson = new RecupererJson(getContext());
        recupererJson.execute();
        String json = getArguments().getString("json");
        Toast.makeText(getContext(),json,Toast.LENGTH_LONG).show();

        return inflater.inflate(R.layout.fragment_fragment_seance_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvfrags1 = view.findViewById(R.id.tvfrags1);
        RecupererJson recupererJson = new RecupererJson(getContext());
        recupererJson.execute();

    }


}