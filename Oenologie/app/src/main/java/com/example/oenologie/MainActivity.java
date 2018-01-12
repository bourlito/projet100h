package com.example.oenologie;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

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

        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
}
