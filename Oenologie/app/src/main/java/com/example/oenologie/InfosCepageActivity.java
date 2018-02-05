package com.example.oenologie;

import android.app.ActionBar;
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
                tvContenu.setText("Superficie de la vigne de la Loire :\n" +
                        "La taille du vignoble est de 70 000 hectares dont 52 000 classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins de Loire :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le cabernet franc, le gamay et le grolleau. Pour le vin blanc : le melon de Bourgogne, le chenin et le sauvignon." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble de la Loire :\n" +
                        "La production de la région est de 45% de vins blancs secs et doux, 23% de vins rouges, 21%de vins rosés et 11% de vins mousseux." +
                        "\n" + "\n" +
                        "Les bons vins de Loire viennent de Sancerre, Savennières, Vouvray, Tours, Cheverny, Nantes, Saint-Pourçain et Amboise.");
                break;
            case "Bordeaux":
                tvContenu.setText("Superficie de la vigne de Bordeaux :\n" +
                        "La taille du vignoble est de 117 500 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins de Bordeaux :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le merlot, le cabernet sauvignon  et le cabernet franc. Pour le vin blanc : la muscadelle, le sémillon et le sauvignon." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble de Bordeaux :\n" +
                        "La production de la région est de 11% de vins blancs secs et doux, 89% de vins rouges et rosés." +
                        "\n" + "\n" +
                        "Les bons vins de Loire viennent de Pauillac, St Julien, St Estèphe, Pessac Léognan, Pomerol et Médoc." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1900, 1929, 1949, 1961, 1982, 1990, 2000 et 2005.");

                break;
            case "Alsace":
                tvContenu.setText("Les vins d'Alsace...");
                break;
            case "Bourgogne":
                tvContenu.setText("Les vins de Bourgogne...");
                break;
            case "Provence & Corse":
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
