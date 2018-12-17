package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private String sIme;
    private String sPrezime;
    private String sRodenje;

    private String sPredmet;
    private String sProfesor;
    private String sGodina;
    private String sECTS;
    private String sPredavanja;
    private String sLV;


    private TextView oIme;
    private TextView oPrezime;
    private TextView oRodenje;

    private TextView oPredmet;
    private TextView oProfesor;
    private TextView oGodina;
    private TextView oECTS;
    private TextView oPredavanja;
    private TextView oLV;

    private Button oBtnEnd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();

        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sRodenje = oExtras.getString("rodenje");


        sPredmet = oExtras.getString("predmet");
        sProfesor = oExtras.getString("profesor");
        sGodina = oExtras.getString("godina");
        sECTS = oExtras.getString("ects");
        sPredavanja = oExtras.getString("predavanja");
        sLV = oExtras.getString("lv");

        oIme = (TextView)findViewById(R.id.txtIme);
        oPrezime = (TextView)findViewById(R.id.txtPrezime);
        oRodenje = (TextView)findViewById(R.id.datumRod);

        oPredmet = (TextView)findViewById(R.id.nazivPredmet);
        oProfesor = (TextView)findViewById(R.id.profIme);
        oGodina = (TextView)findViewById(R.id.akademskaGodina);
        oECTS = (TextView)findViewById(R.id.ectsBroj);
        oPredavanja = (TextView)findViewById(R.id.predavanjaBroj);
        oLV = (TextView)findViewById(R.id.lvBroj);

        oIme.setText(sIme);
        oPrezime.setText(sPrezime);
        oRodenje.setText(sRodenje);

        oPredmet.setText(sPredmet);
        oProfesor.setText(sProfesor);
        oGodina.setText(sGodina);
        oECTS.setText(sECTS);
        oPredavanja.setText(sPredavanja);
        oLV.setText(sLV);


        oBtnEnd = (Button)findViewById(R.id.btnEnd);
        oBtnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SummaryActivity.this, MainActivity.class));
            }
        });

    }
}
