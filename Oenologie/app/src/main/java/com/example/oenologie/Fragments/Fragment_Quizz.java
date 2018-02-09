package com.example.oenologie.Fragments;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oenologie.ConnexionTomcat.AsyncResponse;
import com.example.oenologie.PopUpLogActivity;
import com.example.oenologie.R;

import org.json.JSONException;

import static com.example.oenologie.PopUpLogActivity.MyPREFERENCES;
import static com.example.oenologie.PopUpLogActivity.Name;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Fragment_Quizz extends Fragment implements AsyncResponse{
    private int a=0;
    private LinearLayout LL2;
    private LinearLayout LL4;
    private LinearLayout LLV;
    private TextView tvQuestion;
    private String codesession;
    private String pseudo;
    private String url;

    SharedPreferences mySettings;

    public Fragment_Quizz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quizz, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LL2 = view.findViewById(R.id.LL2);
        LL4 = view.findViewById(R.id.LL4);
        LLV = view.findViewById(R.id.LLV);
        tvQuestion = view.findViewById(R.id.tvQuestiion);

        mySettings = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (mySettings.getString(Name,"").equals("")){
            tvQuestion.setVisibility(View.GONE);
            LLV.setVisibility(View.GONE);

            Intent intent = new Intent(getActivity(),PopUpLogActivity.class);
            startActivityForResult(intent,1);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if (resultCode == Activity.RESULT_OK){
                codesession = data.getStringExtra("codesession");
                pseudo = data.getStringExtra("pseudo");
                Toast.makeText(getContext(), pseudo+"\n"+codesession, Toast.LENGTH_SHORT).show();

                LLV.setVisibility(View.VISIBLE);
                tvQuestion.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void processFinish(String output) throws JSONException{

    }
}