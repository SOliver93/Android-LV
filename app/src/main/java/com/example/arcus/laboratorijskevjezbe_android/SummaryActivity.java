package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    private TextView oIme;
    private TextView oPrezime;
    private TextView oDatum;
    private TextView oKolegij;
    private TextView oProfesor;
    private TextView oGodina;
    private TextView oPredavanje;
    private TextView oVjezbe;
    private String sKolegij;
    private String sProfesor;
    private String sGodina;
    private String sPredavanja;
    private String sVjezbe;
    private String sIme;
    private String sPrezime;
    private String sDatum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        oIme = (TextView)findViewById(R.id.tvIme);
        oPrezime = (TextView)findViewById(R.id.tvPrezime);
        oDatum = (TextView)findViewById(R.id.tvDatum);
        oKolegij = (TextView)findViewById(R.id.tvKolegij);
        oProfesor = (TextView)findViewById(R.id.tvProfesor);
        oGodina = (TextView)findViewById(R.id.tvGod);
        oPredavanje = (TextView)findViewById(R.id.tvPredavanja);
        oVjezbe = (TextView)findViewById(R.id.tvVjezbe);
        final Bundle StudentInfo  = getIntent().getExtras();
        sIme = StudentInfo.getString("ime");
        oIme.setText(sIme);
        sPrezime = StudentInfo.getString("prezime");
        oPrezime.setText(sPrezime);
        sDatum = StudentInfo.getString("datum");
        oDatum.setText(sDatum);
        sKolegij = StudentInfo.getString("kolegij");
        oKolegij.setText(sKolegij);
        sProfesor = StudentInfo.getString("profesor");
        oProfesor.setText(sProfesor);
        sGodina = StudentInfo.getString("godina");
        oGodina.setText(sGodina);
        sPredavanja = StudentInfo.getString("predavanja");
        oPredavanje.setText(sPredavanja);
        sVjezbe = StudentInfo.getString("vjezbe");
        oVjezbe.setText(sVjezbe);
        final Button button = findViewById(R.id.btnDone);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Begining = new Intent(SummaryActivity.this, PersonalInfoActivity.class);
                startActivity(Begining);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}