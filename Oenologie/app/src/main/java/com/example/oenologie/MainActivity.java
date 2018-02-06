package com.example.oenologie;

import android.app.SearchManager;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.oenologie.Classes.Utilisateur;
import com.example.oenologie.Fragments.Fragment_Accueil;
import com.example.oenologie.Fragments.Fragment_Carte;
import com.example.oenologie.Fragments.Fragment_Contact;
import com.example.oenologie.Fragments.Fragment_Quizz;
import com.example.oenologie.Fragments.Fragment_Seance;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    private TextView tv;
    private DatabaseHelper dbHelper = new DatabaseHelper(this);
    private FragmentTransaction fragmentTransaction;
    private NavigationView navigationView;
    private Button btnTest;
    private ImageButton btnFb;
    private View hView;
    private TextView nav_user;

    public static Utilisateur utilisateur = new Utilisateur("",0);

    String JSON_STRING ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawer);
        myToggle = new ActionBarDrawerToggle(this,myDrawer,R.string.open,R.string.close);
        navigationView = findViewById(R.id.navView);
        btnTest = findViewById(R.id.btnTest);
        btnFb = navigationView.findViewById(R.id.btnFb);

        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();

        tv = findViewById(R.id.textintro);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.my_transition);
        tv.startAnimation(myanim);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);

        hView = navigationView.getHeaderView(0);
        nav_user = hView.findViewById(R.id.testPseudoNav);
        nav_user.setText("".equals(utilisateur.getPseudo()) || utilisateur.getPseudo().equals(null) ? "Non connecté" : String.format("%s", utilisateur.getPseudo()));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.accueil:
                        tv.setVisibility(View.GONE);
                        btnTest.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Accueil());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Accueil");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.seance:
                        tv.setVisibility(View.GONE);
                        btnTest.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Seance());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Séances");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.carte:
                        tv.setVisibility(View.GONE);
                        btnTest.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Carte());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Carte Intéractive");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.quizz:
                        tv.setVisibility(View.GONE);
                        btnTest.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Quizz());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Quizz!");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.contact:
                        tv.setVisibility(View.GONE);
                        btnTest.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Contact());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Contact & Adresses");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;
                }
                return true;
            }
        });

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "https://www.facebook.com/oenologie.hei.5?ref=br_rs");
                startActivity(intent);
            }
        });
    }

    public void getJson(View view){
        new BackgroundTask().execute();

    }

    private class BackgroundTask extends AsyncTask<Void, Void, String> {
        String JSON_URL;
        @Override
        protected void onPreExecute() {
            JSON_URL ="http://192.168.0.27/test/seance1.php";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                StringBuilder JSON_DATA = new StringBuilder();
                URL url = new URL(JSON_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream  in = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                while ((JSON_STRING = reader.readLine())!=null) {
                    JSON_DATA.append(JSON_STRING).append("\n");
                }
                return JSON_DATA.toString().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView json = findViewById(R.id.tvfrags1);
            json.setText(result);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });
    }
}
