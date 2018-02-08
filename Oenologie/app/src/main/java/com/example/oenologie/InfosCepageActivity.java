package com.example.oenologie;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfosCepageActivity extends AppCompatActivity {
    private TextView tvIntro;
    private TextView tvContenu;
    private TextView tvContenu2;
    private TextView tvContenu3;
    private TextView tvContenu4;
    private TextView tvTContenu5;
    private TextView tvContenu5;
    private ImageView imageView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_cepage);
        imageView = findViewById(R.id.imageView);
        tvIntro = findViewById(R.id.textintro);
        tvContenu = findViewById(R.id.textcontenu);
        tvContenu2 = findViewById(R.id.textcontenu2);
        tvContenu3 = findViewById(R.id.textcontenu3);
        tvContenu4 = findViewById(R.id.textcontenu4);
        tvTContenu5 = findViewById(R.id.textTcontenu5);
        tvContenu5 = findViewById(R.id.textcontenu5);

        Bundle bundle = getIntent().getExtras();
        tvIntro.setText(bundle.getString("zone"));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        switch (bundle.getString("zone")){
            case "Loire":
                tvContenu.setText("70 000 hectares dont 52 000 classés en AOC-AOP."
                );
                tvContenu2.setText("Vin rouge : cabernet franc, gamay, grolleau.\nVin blanc : melon de Bourgogne, chenin, sauvignon."
                );
                tvContenu3.setText("45% de vins blancs secs et doux, 23% de vins rouges, 21%de vins rosés et 11% de vins mousseux."
                );
                tvContenu4.setText("Sancerre, Savennières, Vouvray, Tours, Cheverny, Nantes, Saint-Pourçain et Amboise."
                );
                tvContenu5.setVisibility(View.GONE);
                tvTContenu5.setVisibility(View.GONE);
                break;

            case "Bordeaux":
                tvContenu.setText("La taille du vignoble est de 117 500 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : le merlot, le cabernet sauvignon  et le cabernet franc. Pour le vin blanc : la muscadelle, le sémillon et le sauvignon."
                );
                tvContenu3.setText("La production de la région est de 11% de vins blancs secs et doux, 89% de vins rouges et rosés."
                );
                tvContenu4.setText("Les bons vins de Bordeaux viennent de Pauillac, St Julien, St Estèphe, Pessac Léognan, Pomerol et Médoc."
                );

                tvContenu5.setText("Les meilleurs vins datent des millésimes 1900, 1929, 1949, 1961, 1982, 1990, 2000 et 2005."
                );
                break;

            case "Alsace":
                tvContenu.setText("La taille du vignoble est de 15 600 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Le cépage qui compose le vignoble est pour le vin rouge  le pinot noir. Pour le vin blanc : le riesling, le gewurztraminer, le sylvaner, le pinot gris et le muscat."
                );
                tvContenu3.setText("La production de la région est de 70% de vins blancs secs et doux, 10% de vins rouges et 20% de vins mousseux."
                );
                tvContenu4.setText("Les bons vins d'Alsace viennent d'Altenberg, Menchberg, Osterberg et Vorbourg."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1921, 1928, 1929, 1937, 1945, 1947, 1961, 1983, 1985, 1990 et 2000."
                );
                break;

            case "Bourgogne":
                tvContenu.setText("La taille du vignoble est de 29 500 hectares dont 25 000 classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : le pinot noir et le gamay. Pour le vin blanc : le chardonnay et l'aligoté."
                );
                tvContenu3.setText("La production de la région est de 61% de vins blancs secs, 39% de vins rouges et rosés."
                );
                tvContenu4.setText("Les bons vins de Bourgogne viennent de Romanée-Conti, Echezaux, Chambertin, Montrachet, Chambolle-Musigny, Meursault, Chablis, Nuits-Sait-Georges, Pommard, Givry et Beaune."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1929, 1934, 1945, 1947, 1961, 1969, 1986, 1996, 1999 et 2009."
                );
                break;

            case "Provence & Corse":
                tvContenu.setText("La taille du vignoble est de 34 180 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : le grenache, le mourvèdre, le cinsault, le tibouren, la syrah, le cabernet sauvignon, le carrignan, le niellucio, le sciacarello et le carcajolo noir. Pour le vin blanc : la clairette, le vermentino, le sémillon, l'ugni-blanc et le carcajolo blanc."
                );
                tvContenu3.setText("La production de la région est de 5% de vins blancs secs, 40% de vins rouges et 55% de vins rosés."
                );
                tvContenu4.setText("Les bons vins de Provence & Corse viennent de Bandol, Cassis, Aix-en-Provence, Ajaccio et Calvi."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1988, 1989, 1990, 1998, 2000, 2006 et 200è."
                );
                break;

            case "Lorraine":
                tvContenu.setText("La taille du vignoble est de 180 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : le pinot noir et le gamay. Pour le vin blanc : l'auxerrois et le chardonnay."
                );
                tvContenu3.setText("La production de la région est de 5% de vins blancs secs, 95% de vins gris et rouges."
                );
                tvContenu4.setText("Les bons vins de Lorraine viennent de Lucey, Bruley, Charmes-la-Côte, Mont-le-Vignoble et Bulligny."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1921, 1918, 1945, 1961, 1983, 1990 et 2000."
                );
                break;

            case "Champagne":
                tvContenu.setText("La taille du vignoble est de 33 344 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : le pinot noir, le pinot meunier et le chardonnay. Pour le vin rosé de Riceys : le pinot noir et le pinot meunier."
                );
                tvContenu3.setText("La production de la région est de 90% de vins mousseux, 5% de vins rouges et 5% de vins rosés."
                );
                tvContenu4.setText("Les bons vins de Champagne viennent d'Avize, Epernay, Cramant, Cuis, Chouilly, Vertus et Mesnil."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1900, 1911, 1914, 1921, 1937, 1955, 1975, 1990, 1996 et 2002."
                );
                break;

            case "Sud-Ouest":
                tvContenu.setText("La taille du vignoble est de 57 500 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : le merlot, le côt malbec, le duras, le tannat, la négrette, le cabernet sauvignon  et le cabernet franc. Pour le vin blanc : le gros manseng,le petit manseng, le mauzac, l'arrufiac et le sauvignon."
                );
                tvContenu3.setText("La production de la région est de 20% de vins blancs secs, 80% de vins rouges et rosés."
                );
                tvContenu4.setText("Les bons vins du Sud-Ouest viennent de Cahors, Gaillac, Jurançon, Agen et Bergerac."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1985, 1987 et 1998."
                );
                break;

            case "Savoie":
                tvContenu.setText("La taille du vignoble est de 5 771 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : le poulsard, la mondeuse, le pinot noir et le gamay. Pour le vin blanc : le chardonnay, la jacquère, la roussanne, l'altesse, le chasselas et la molette."
                );
                tvContenu3.setText("La production de la région est de 61% de vins blancs secs, 39% de vins rouges et rosés."
                );
                tvContenu4.setText("Les bons vins de Savoie-Bugey viennent d'Apremont et Montagieux."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1988, 1990, 1995, 2002 et 2005."
                );
                break;

            case "Rhône":
                tvContenu.setText("La taille du vignoble est de 73 838 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : la syrah, le grenache, le gamay (coteaux du Lyonnais) et le mourvèdre. Pour le vin blanc : le viognier, la roussance, la marsanne, le grenache blanc, le bourboulenc et le chardonnay (coteaux du Lyonnais)."
                );
                tvContenu3.setText("La production de la région est de 60,5% de vins blancs secs, 31% de vins rouges et 8,5% de vins rosés."
                );
                tvContenu4.setText("Les bons vins du Rhône viennent de Condrieu, Vinsobres, Rasteau, Avignon, Ampuis et Châteauneuf-du-Rhône."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1911, 1923, 1929, 1945, 1961, 1978, 1998 et 2007."
                );
                break;

            case "Languedoc":
                tvContenu.setText("La taille du vignoble est de 246 000 hectares classés en AOC-AOP."
                );
                tvContenu2.setText("Les cépages qui composent le vignoble sont pour le vin rouge : le grenache, le mourvèdre, la syrah, le carignan et le cinsault. Pour le vin blanc : la marsanne, le bourboulenc, le grenache blanc et la roussance."
                );
                tvContenu3.setText("La production de la région est de 15% de vins blancs secs et doux, 85% de vins rouges et rosés."
                );
                tvContenu4.setText("Les bons vins du Languedoc-Roussillon viennent de Banyuls, Collioure, Saint-Jean-de-Minervois, Lesquerde et Tautavel."
                );
                tvContenu5.setText("Les meilleurs vins datent des millésimes 1990, 1991, 1995, 1998, 2001, 2003, 2004, 2005, 2006 et 2010."
                );
                break;

            default:
                tvContenu.setText("Erreur");
                break;
        }
    }
}
