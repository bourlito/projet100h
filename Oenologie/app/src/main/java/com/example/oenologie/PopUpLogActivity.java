package com.example.oenologie;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_signin);
        etcodesession = findViewById(R.id.codesession);
        etpseudo = findViewById(R.id.pseudo);
        btndemarrer = findViewById(R.id.btndemarrer);

        btndemarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codesession = etcodesession.getText().toString();
                pseudo = etpseudo.getText().toString();
                Intent intent = new Intent(PopUpLogActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
