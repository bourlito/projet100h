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
import com.example.oenologie.ConnexionTomcat.RecupererJson;
import com.example.oenologie.PopUpLogActivity;
import com.example.oenologie.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.oenologie.PopUpLogActivity.Code;
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
    private TextView tvReponse1;
    private TextView tvReponse2;
    private TextView tvReponse3;
    private TextView tvReponse4;
    private String urlS1 = "https://thomas-chevalier.fr/android/quizzS1";
    private String urlS2 = "https://thomas-chevalier.fr/android/quizzS2";
    private String urlS3 = "https://thomas-chevalier.fr/android/quizzS3";
    private RecupererJson recupererJson;

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
        tvReponse1 = view.findViewById(R.id.tvReponse1);
        tvReponse2 = view.findViewById(R.id.tvReponse2);
        tvReponse3 = view.findViewById(R.id.tvReponse3);
        tvReponse4 = view.findViewById(R.id.tvReponse4);

        recupererJson = new RecupererJson();
        recupererJson.delegate = this;

        mySettings = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (mySettings.getString(Name,"").equals("")){
            Intent intent = new Intent(getActivity(),PopUpLogActivity.class);
            startActivityForResult(intent,1);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if (resultCode == Activity.RESULT_OK){
            }
        }
    }

    @Override
    public void processFinish(String output) throws JSONException{
        tvQuestion.setVisibility(View.VISIBLE);
        LLV.setVisibility(View.VISIBLE);
        LL2.setVisibility(View.VISIBLE);

        JSONObject mainObject = new JSONObject(output);
        JSONArray mainArray = mainObject.getJSONArray("server_response");
        JSONObject object1 = mainArray.getJSONObject(0);
        JSONArray rep = object1.getJSONArray("Reponses");
        JSONObject rep1 = rep.getJSONObject(0);
        JSONObject rep2 = rep.getJSONObject(1);
        tvQuestion.setText(object1.getString("Libelle_question"));
        tvReponse1.setText(rep1.getString("Libelle_reponse"));
        tvReponse2.setText(rep2.getString("Libelle_reponse"));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mySettings.getString(Code,null) != null){
            switch (mySettings.getString(Code,null)){
                case "171023":
                    recupererJson.execute(urlS1);
                    break;
                case "180129":
                    recupererJson.execute(urlS2);
                    break;
                case "180312":
                    recupererJson.execute(urlS3);
                    break;
            }
        }
    }
}