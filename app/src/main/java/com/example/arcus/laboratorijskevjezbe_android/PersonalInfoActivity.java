package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInfoActivity extends AppCompatActivity {
    private EditText oIme;
    public String sIme;
    private EditText oPrezime;
    public String sPrezime;
    private EditText oDatum;
    public String sDatum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        final Button button = findViewById(R.id.btnOk);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                oIme = (EditText) findViewById(R.id.etIme);
                oPrezime = (EditText) findViewById(R.id.etPrezime);
                oDatum = (EditText) findViewById(R.id.etDatum);
                sIme = oIme.getText().toString();
                sPrezime = oPrezime.getText().toString();
                sDatum = oDatum.getText().toString();
                Intent Upisi = new Intent(PersonalInfoActivity.this, StudentInfoActivity.class);
                Bundle Extras = new Bundle();
                Extras.putString("ime", sIme);
                Extras.putString("prezime", sPrezime);
                Extras.putString("datum", sDatum);
                Upisi.putExtras(Extras);
                startActivity(Upisi);
            }
        });

    }
    @Override
    public void onBackPressed() {

    }
}