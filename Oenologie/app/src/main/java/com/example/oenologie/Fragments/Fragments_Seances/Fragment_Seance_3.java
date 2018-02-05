package com.example.oenologie.Fragments.Fragments_Seances;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oenologie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Seance_3 extends Fragment {
    private TextView tvfrags3;

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

        tvfrags3.setText("Déroulement :...\n\n\nVins à découvir :...");
    }
}
