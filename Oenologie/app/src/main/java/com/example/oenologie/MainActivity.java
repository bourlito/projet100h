package com.example.oenologie;


import android.app.Activity;
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

public class MainActivity extends AppCompatActivity {

    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    private TextView tv;
    private DatabaseHelper dbHelper = new DatabaseHelper(this);
    private FragmentTransaction fragmentTransaction;
    private NavigationView navigationView;

    private static String url =
            "https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=mel_piscines&facet=commune&rows=-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawer);
        myToggle = new ActionBarDrawerToggle(this,myDrawer,R.string.open,R.string.close);
        navigationView = findViewById(R.id.navView);

        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();

        tv = findViewById(R.id.textintro);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.my_transition);
        tv.startAnimation(myanim);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.accueil:
                        tv.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Accueil());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Accueil");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.seance:
                        tv.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Seance());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Séances");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.carte:
                        tv.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Carte());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Carte Intéractive");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.quizz:
                        tv.setVisibility(View.GONE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flcontent,new Fragment_Quizz());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Quizz!");
                        item.setChecked(true);
                        myDrawer.closeDrawers();
                        break;

                    case R.id.contact:
                        tv.setVisibility(View.GONE);
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
