package com.example.oenologie;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oenologie.Fragments.Fragment_Accueil;
import com.example.oenologie.Fragments.Fragment_Carte;
import com.example.oenologie.Fragments.Fragment_Quizz;
import com.example.oenologie.Fragments.Fragment_Seance;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawer = findViewById(R.id.myDrawer);
        myToggle = new ActionBarDrawerToggle(this,myDrawer,R.string.open,R.string.close);
        NavigationView navigationView = findViewById(R.id.navView);

        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);

        tv = findViewById(R.id.textintro);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.my_transition);
        tv.startAnimation(myanim);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)){
            int id = item.getItemId();
            if (id == R.id.accueil){
                Toast.makeText(this,"accueil",Toast.LENGTH_SHORT).show();
            }else if (id == R.id.carte){
                Toast.makeText(this,"carte",Toast.LENGTH_SHORT).show();
            }else if (id == R.id.quizz){
                Toast.makeText(this,"quizz",Toast.LENGTH_SHORT).show();
            }else if (id == R.id.seance){
                Toast.makeText(this,"seance",Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer(MenuItem menuItem){
        Fragment myFragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()){
            case R.id.accueil:
                fragmentClass = Fragment_Accueil.class;
                break;
            case R.id.carte:
                fragmentClass = Fragment_Carte.class;
                break;
            case R.id.seance:
                fragmentClass = Fragment_Seance.class;
                break;
            case R.id.quizz:
                fragmentClass = Fragment_Quizz.class;
                break;
            default:
                fragmentClass = MainActivity.class;
        }
        try {
            myFragment = (Fragment) fragmentClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flcontent,myFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        myDrawer.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }
}
