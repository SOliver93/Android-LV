package com.example.arcus.laboratorijskevjezbe_android.listeners;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity
{
    private String sIme;
    private TextView oIme;
    private String sPrezime;
    private TextView oPrezime;
    private String sDatumRodenja;
    private TextView oDatumRodenja;
    private String sPredmet;
    private TextView oPredmet;
    private String sProfesor;
    private TextView oProfesor;
    private String sAkGodina;
    private TextView oAkGodina;
    private String sBrojSati;
    private TextView oBrojSati;
    private String sBrojSatiLV;
    private TextView oBrojSatiLV;
    public Button oBtnKraj;
    private ArrayList<Studenti> list = new ArrayList<>();
    public Studenti oStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatumRodenja = oExtras.getString("datum_rodenja");
        sPredmet = oExtras.getString("predmet");
        sProfesor = oExtras.getString("profesor");
        sAkGodina = oExtras.getString("ak_godina");
        sBrojSati = oExtras.getString("broj_sati");
        sBrojSatiLV = oExtras.getString("broj_sati_lv");
        oStudent = new Studenti(sIme,sPrezime,sDatumRodenja,sPredmet,sProfesor,sAkGodina,sBrojSati,sBrojSatiLV);

        oIme = (TextView)findViewById(R.id.textviewIme);
        oIme.setText(sIme);

        oPrezime = (TextView)findViewById(R.id.textviewPrezime);
        oPrezime.setText(sPrezime);

        oDatumRodenja = (TextView)findViewById(R.id.textviewDatumRodenja);
        oDatumRodenja.setText(sDatumRodenja);

        oPredmet = (TextView)findViewById(R.id.textviewPredmet);
        oPredmet.setText(sPredmet);

        oProfesor = (TextView)findViewById(R.id.textviewProfesor);
        oProfesor.setText(sProfesor);

        oAkGodina = (TextView)findViewById(R.id.textviewAkGodina);
        oAkGodina.setText(sAkGodina);

        oBrojSati = (TextView)findViewById(R.id.textviewBrojSati);
        oBrojSati.setText(sBrojSati);

        oBrojSatiLV = (TextView)findViewById(R.id.textviewBrojSatiLV);
        oBrojSatiLV.setText(sBrojSatiLV);

        oBtnKraj = (Button)findViewById(R.id.btnKraj);
        oBtnKraj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent oIspisiStudente = new Intent(getApplicationContext(), MainMainActivity.class);
                list = (ArrayList<Studenti>) oIspisiStudente.getSerializableExtra("list");
                oIspisiStudente.putExtra("student", (Serializable) oStudent);
                startActivity(oIspisiStudente);
            }
        });

    }
}
