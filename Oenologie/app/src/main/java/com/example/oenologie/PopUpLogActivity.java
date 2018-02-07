package com.example.oenologie;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PopUpLogActivity extends AppCompatActivity {
    private EditText etcodesession;
    private EditText etpseudo;
    private Button btndemarrer;

    private String codesession;
    private String pseudo;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    SharedPreferences mySettings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_signin);
        etcodesession = findViewById(R.id.codesession);
        etpseudo = findViewById(R.id.pseudo);
        btndemarrer = findViewById(R.id.btndemarrer);

        mySettings = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE );
        editor = mySettings.edit();

        btndemarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codesession = etcodesession.getText().toString();
                pseudo = etpseudo.getText().toString();
                Intent returnIntent = new Intent();
                if (codesession.equals("12345THET") && !pseudo.equals("")){
                    returnIntent.putExtra("codesession",codesession);
                    returnIntent.putExtra("pseudo",pseudo);
                    setResult(Activity.RESULT_OK,returnIntent);
                    editor.putString(Name, pseudo);
                    editor.commit();
                    finish();
                }else if (pseudo.equals("")){
                    Toast.makeText(PopUpLogActivity.this, "PSEUDO INVALIDE", Toast.LENGTH_SHORT).show();
                }else if (!codesession.equals("12345THET")){
                    Toast.makeText(PopUpLogActivity.this, "CODE SESSION INVALIDE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
