package com.example.oenologie.Fragments;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oenologie.Fragments.Fragments_Seances.Fragment_Seance_1;
import com.example.oenologie.Fragments.Fragments_Seances.Fragment_Seance_2;
import com.example.oenologie.Fragments.Fragments_Seances.Fragment_Seance_3;
import com.example.oenologie.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment_Seance extends Fragment {

    public Fragment_Seance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_seance, container, false);
    }
}
