package com.example.oenologie;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfosCepageActivity extends AppCompatActivity {
    private TextView tvIntro;
    private TextView tvContenu;

    @SuppressLint("SetTextI18n")
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
                tvContenu.setText("Superficie de la vigne de Loire :\n" +
                        "La taille du vignoble est de 70 000 hectares dont 52 000 classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins de Loire :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le cabernet franc, le gamay et le grolleau. Pour le vin blanc : le melon de Bourgogne, le chenin et le sauvignon." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble de Loire :\n" +
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
                        "Les bons vins de Bordeaux viennent de Pauillac, St Julien, St Estèphe, Pessac Léognan, Pomerol et Médoc." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1900, 1929, 1949, 1961, 1982, 1990, 2000 et 2005.");
                break;

            case "Alsace":
                tvContenu.setText("Superficie de la vigne d'Alsace :\n" +
                        "La taille du vignoble est de 15 600 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins d'Alsace :\n" +
                        "Le cépage qui compose le vignoble est pour le vin rouge  le pinot noir. Pour le vin blanc : le riesling, le gewurztraminer, le sylvaner, le pinot gris et le muscat." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble d'Alsace :\n" +
                        "La production de la région est de 70% de vins blancs secs et doux, 10% de vins rouges et 20% de vins mousseux." +
                        "\n" + "\n" +
                        "Les bons vins d'Alsace viennent d'Altenberg, Menchberg, Osterberg et Vorbourg." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1921, 1928, 1929, 1937, 1945, 1947, 1961, 1983, 1985, 1990 et 2000.");

                break;

            case "Bourgogne":
                tvContenu.setText("Superficie de la vigne de Bourgogne :\n" +
                        "La taille du vignoble est de 29 500 hectares dont 25 000 classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins de Bourgogne :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le pinot noir et le gamay. Pour le vin blanc : le chardonnay et l'aligoté." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble de Bourgogne :\n" +
                        "La production de la région est de 61% de vins blancs secs, 39% de vins rouges et rosés." +
                        "\n" + "\n" +
                        "Les bons vins de Bourgogne viennent de Romanée-Conti, Echezaux, Chambertin, Montrachet, Chambolle-Musigny, Meursault, Chablis, Nuits-Sait-Georges, Pommard, Givry et Beaune." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1929, 1934, 1945, 1947, 1961, 1969, 1986, 1996, 1999 et 2009.");
                break;

            case "Provence & Corse":
                tvContenu.setText("Superficie de la vigne en Provence & Corse :\n" +
                        "La taille du vignoble est de 34 180 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins en Provence & Corse :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le grenache, le mourvèdre, le cinsault, le tibouren, la syrah, le cabernet sauvignon, le carrignan, le niellucio, le sciacarello et le carcajolo noir. Pour le vin blanc : la clairette, le vermentino, le sémillon, l'ugni-blanc et le carcajolo blanc." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble de Provence & Corse :\n" +
                        "La production de la région est de 5% de vins blancs secs, 40% de vins rouges et 55% de vins rosés." +
                        "\n" + "\n" +
                        "Les bons vins de Provence & Corse viennent de Bandol, Cassis, Aix-en-Provence, Ajaccio et Calvi." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1988, 1989, 1990, 1998, 2000, 2006 et 200è.");
                break;

            case "Lorraine":
                tvContenu.setText("Superficie de la vigne de Lorraine :\n" +
                        "La taille du vignoble est de 180 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins de Lorraine :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le pinot noir et le gamay. Pour le vin blanc : l'auxerrois et le chardonnay." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble de Lorraine :\n" +
                        "La production de la région est de 5% de vins blancs secs, 95% de vins gris et rouges." +
                        "\n" + "\n" +
                        "Les bons vins de Lorraine viennent de Lucey, Bruley, Charmes-la-Côte, Mont-le-Vignoble et Bulligny." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1921, 1918, 1945, 1961, 1983, 1990 et 2000.");
                break;

            case "Champagne":
                tvContenu.setText("Superficie de la vigne de Champagne :\n" +
                        "La taille du vignoble est de 33 344 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins de Champagne :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le pinot noir, le pinot meunier et le chardonnay. Pour le vin rosé de Riceys : le pinot noir et le pinot meunier." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble de Champagne :\n" +
                        "La production de la région est de 90% de vins mousseux, 5% de vins rouges et 5% de vins rosés." +
                        "\n" + "\n" +
                        "Les bons vins de Champagne viennent d'Avize, Epernay, Cramant, Cuis, Chouilly, Vertus et Mesnil." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1900, 1911, 1914, 1921, 1937, 1955, 1975, 1990, 1996 et 2002.");
                break;

            case "Sud-Ouest":
                tvContenu.setText("Superficie de la vigne du Sud-Ouest :\n" +
                        "La taille du vignoble est de 57 500 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins du Sud-Ouest :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le merlot, le côt malbec, le duras, le tannat, la négrette, le cabernet sauvignon  et le cabernet franc. Pour le vin blanc : le gros manseng,le petit manseng, le mauzac, l'arrufiac et le sauvignon." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble du Sud-Ouest :\n" +
                        "La production de la région est de 20% de vins blancs secs, 80% de vins rouges et rosés." +
                        "\n" + "\n" +
                        "Les bons vins du Sud-Ouest viennent de Cahors, Gaillac, Jurançon, Agen et Bergerac." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1985, 1987 et 1998.");
                break;

            case "Savoie":
                tvContenu.setText("Superficie de la vigne de Savoie-Bugey :\n" +
                        "La taille du vignoble est de 5 771 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins de Savoie-Bugey :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le poulsard, la mondeuse, le pinot noir et le gamay. Pour le vin blanc : le chardonnay, la jacquère, la roussanne, l'altesse, le chasselas et la molette." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble de Savoie-Bugey :\n" +
                        "La production de la région est de 61% de vins blancs secs, 39% de vins rouges et rosés." +
                        "\n" + "\n" +
                        "Les bons vins de Savoie-Bugey viennent d'Apremont et Montagieux." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1988, 1990, 1995, 2002 et 2005.");
                break;

            case "Rhône":
                tvContenu.setText("Superficie de la vigne du Rhône :\n" +
                        "La taille du vignoble est de 73 838 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins du Rhône :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : la syrah, le grenache, le gamay (coteaux du Lyonnais) et le mourvèdre. Pour le vin blanc : le viognier, la roussance, la marsanne, le grenache blanc, le bourboulenc et le chardonnay (coteaux du Lyonnais)." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble du Rhône :\n" +
                        "La production de la région est de 60,5% de vins blancs secs, 31% de vins rouges et 8,5% de vins rosés." +
                        "\n" + "\n" +
                        "Les bons vins du Rhône viennent de Condrieu, Vinsobres, Rasteau, Avignon, Ampuis et Châteauneuf-du-Rhône." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1911, 1923, 1929, 1945, 1961, 1978, 1998 et 2007.");
                break;

            case "Languedoc":
                tvContenu.setText("Superficie de la vigne du Languedoc-Roussilon :\n" +
                        "La taille du vignoble est de 246 000 hectares classés en AOC-AOP." +
                        "\n" + "\n" +
                        "Cépages des vins du Languedoc-Roussilon :\n" +
                        "Les cépages qui composent le vignoble sont pour le vin rouge : le grenache, le mourvèdre, la syrah, le carignan et le cinsault. Pour le vin blanc : la marsanne, le bourboulenc, le grenache blanc et la roussance." +
                        "\n" + "\n" +
                        "Vins produits dans le vignoble du Languedoc-Roussillon :\n" +
                        "La production de la région est de 15% de vins blancs secs et doux, 85% de vins rouges et rosés." +
                        "\n" + "\n" +
                        "Les bons vins du Languedoc-Roussillon viennent de Banyuls, Collioure, Saint-Jean-de-Minervois, Lesquerde et Tautavel." +
                        "\n" + "\n" +
                        "Les meilleurs vins datent des millésimes 1990, 1991, 1995, 1998, 2001, 2003, 2004, 2005, 2006 et 2010.");
                break;

            default:
                tvContenu.setText("Erreur");
                break;
        }
    }
}
