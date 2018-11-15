package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StudentInfoActivity extends AppCompatActivity {
    private EditText oKolegij;
    private String sKolegij;
    private EditText oProfesor;
    private String sProfesor;
    private EditText oGodina;
    private String sGodina;
    private EditText oPredavanja;
    private String sPredavanja;
    private EditText oVjezbe;
    private String sVjezbe;
    private TextView oIme;
    private String sIme;
    private TextView oPrezime;
    private String sPrezime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        final Bundle PersonalInfo  = getIntent().getExtras();
        oKolegij = (EditText)findViewById(R.id.etKolegij);
        oProfesor = (EditText)findViewById(R.id.etProfesor);
        oGodina = (EditText)findViewById(R.id.etGodina);
        oPredavanja = (EditText)findViewById(R.id.etPredavanja);
        oVjezbe = (EditText)findViewById(R.id.etVjezbe);
        sIme = PersonalInfo.getString("ime");
        sPrezime = PersonalInfo.getString("prezime");
        oIme = (TextView)findViewById(R.id.tvIme);
        oPrezime = (TextView)findViewById(R.id.tvPrezime);
        oIme.setText(sIme);
        oPrezime.setText(sPrezime);
        final Button button = findViewById(R.id.btnDalje);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sKolegij = oKolegij.getText().toString();
                sProfesor = oProfesor.getText().toString();
                sGodina = oGodina.getText().toString();
                sPredavanja = oPredavanja.getText().toString();
                sVjezbe = oVjezbe.getText().toString();
                Bundle Extras = new Bundle();
                Extras.putString("kolegij", sKolegij);
                Extras.putString("profesor", sProfesor);
                Extras.putString("godina", sGodina);
                Extras.putString("predavanja", sPredavanja);
                Extras.putString("vjezbe", sVjezbe);
                Intent Summary = new Intent(StudentInfoActivity.this, SummaryActivity.class);
                Summary.putExtras(Extras);
                Summary.putExtras(PersonalInfo);
                startActivity(Summary);
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}