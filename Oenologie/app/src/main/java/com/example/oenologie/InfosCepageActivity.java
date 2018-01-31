package com.example.oenologie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfosCepageActivity extends AppCompatActivity {
    private TextView tvIntro;
    private TextView tvContenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_cepage);
        tvIntro = findViewById(R.id.textintro);
        tvContenu = findViewById(R.id.textcontenu);

        Bundle bundle = getIntent().getExtras();
        tvIntro.setText(bundle.getString("zone"));

        switch (bundle.getString("zone")){
            case "Loire":
                tvContenu.setText("Les vins de Loire...");
                break;
            case "Provence & Corse":
                tvContenu.setText("Les vins de Provence et de Corse...");
                break;
            case "Alsace":
                tvContenu.setText("Les vins d'Alsace...");
                break;
            case "Bourgogne":
                tvContenu.setText("Les vins de Bourgogne...");
                break;
            case "Bordeaux":
                tvContenu.setText("Les vins de Bordeaux...");
                break;
            case "Lorraine":
                tvContenu.setText("Les vins de Lorraine...");
                break;
            case "Champagne":
                tvContenu.setText("Les vins de Champagne...");
                break;
            case "Sud-Ouest":
                tvContenu.setText("Les vins du Sud-Ouest...");
                break;
            case "Savoie":
                tvContenu.setText("Les vins de Savoie...");
                break;
            case "Rhone":
                tvContenu.setText("Les vins du Rhone...");
                break;
            case "Languedoc":
                tvContenu.setText("Les vins du Languedoc...");
                break;
            default:
                tvContenu.setText("Erreur");
                break;
        }
    }
}
