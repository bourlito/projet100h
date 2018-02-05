package com.example.oenologie;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oenologie.Fragments.Fragment_Accueil;
import com.example.oenologie.Fragments.Fragment_Carte;
import com.example.oenologie.Fragments.Fragment_Contact;
import com.example.oenologie.Fragments.Fragment_Quizz;
import com.example.oenologie.Fragments.Fragment_Seance;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout myDrawer;
    private ConstraintLayout cl;
    private ActionBarDrawerToggle myToggle;
    private TextView tv;
    private EditText etcodesession;
    private EditText etpseudo;
    private DatabaseHelper dbHelper = new DatabaseHelper(this);
    private FragmentTransaction fragmentTransaction;
    private Dialog dialog;
    private NavigationView navigationView;
    private View inflateDialog;
    private Button btndemarrer;

    String JSON_STRING ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawer);
        cl = findViewById(R.id.id_cl);
        myToggle = new ActionBarDrawerToggle(this,myDrawer,R.string.open,R.string.close);
        navigationView = findViewById(R.id.navView);

        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();

        tv = findViewById(R.id.textintro);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.my_transition);
        tv.startAnimation(myanim);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_signin);
        inflateDialog = getLayoutInflater().inflate(R.layout.dialog_signin,null);
        btndemarrer = inflateDialog.findViewById(R.id.btndemarrer);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                btndemarrer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        etcodesession = inflateDialog.findViewById(R.id.codesession);
                        etpseudo = inflateDialog.findViewById(R.id.pseudo);
                        Toast.makeText(MainActivity.this, etpseudo.getText().toString()+""+etcodesession.getText().toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        setupDrawerContent(navigationView);
                    }
                });
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.accueil:
                        tv.setVisibility(View.GONE);
                        cl.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Accueil());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Accueil");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.seance:
                        tv.setVisibility(View.GONE);
                        cl.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Seance());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Séances");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.carte:
                        tv.setVisibility(View.GONE);
                        cl.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Carte());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Carte Intéractive");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.quizz:
                        tv.setVisibility(View.GONE);
                        cl.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Quizz());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Quizz!");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.contact:
                        tv.setVisibility(View.GONE);
                        cl.setVisibility(View.GONE);
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
    }

    public void getJson(View view){
        new BackgroundTask().execute();

    }

    private class BackgroundTask extends AsyncTask<Void, Void, String> {
        String JSON_URL;
        @Override
        protected void onPreExecute() {
            JSON_URL ="http://10.122.151.10/test/seance1.php";
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
            TextView json = (TextView) findViewById(R.id.JSon);
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
