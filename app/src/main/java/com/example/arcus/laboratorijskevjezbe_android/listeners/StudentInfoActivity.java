package com.example.arcus.laboratorijskevjezbe_android.listeners;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.arcus.laboratorijskevjezbe_android.R;

public class StudentInfoActivity extends AppCompatActivity
{
    private Button oBtnUpisi;
    private String sIme;
    private String sPrezime;
    private String sDatumRodenja;

    private TextView oIme;
    //private TextView oTextviewIme;
    private EditText oInputPredmet;
    private EditText oInputProfesor;
    private EditText oInputAkGodina;
    private EditText oInputBrojSati;
    private EditText oInputBrojSatiLV;
    private String sPredmet;
    private String sProfesor;
    private String sAkGodina;
    private String sBrojSati;
    private String sBrojSatiLV;


    //private ArrayList<Studenti> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_info);
        oBtnUpisi = (Button)findViewById(R.id.btnUpisi);
        oInputPredmet = (EditText)findViewById(R.id.edittextPredmet);
        oInputProfesor = (EditText)findViewById(R.id.edittextProfesor);
        oInputAkGodina = (EditText)findViewById(R.id.edittextAkademskaGodina);
        oInputBrojSati = (EditText)findViewById(R.id.edittextBrojSati);
        oInputBrojSatiLV = (EditText)findViewById(R.id.edittextBrojSatiLV);



        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatumRodenja = oExtras.getString("datum_rodenja");


        //oIme = (TextView)findViewById(R.id.textviewIme);
        //oIme.setText(sIme);

        //oTextviewIme = (TextView) findViewById(R.id.textviewIme);

        oBtnUpisi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //startActivity(new Intent(StudentInfoActivity.this, SummaryActivity.class)); ne radi jer moramo proslijediti parametre

                sPredmet = oInputPredmet.getText().toString();
                sProfesor=oInputProfesor.getText().toString();
                sAkGodina=oInputAkGodina.getText().toString();
                sBrojSati=oInputBrojSati.getText().toString();
                sBrojSatiLV=oInputBrojSatiLV.getText().toString();

                Intent oUpisiPredmet = new Intent(getApplicationContext(), SummaryActivity.class);
                //list = (ArrayList<Studenti>) oUpisiPredmet.getSerializableExtra("list");
                oUpisiPredmet.putExtra("ime", sIme);
                oUpisiPredmet.putExtra("prezime", sPrezime);
                oUpisiPredmet.putExtra("datum_rodenja", sDatumRodenja);

                oUpisiPredmet.putExtra("predmet", sPredmet);
                oUpisiPredmet.putExtra("profesor", sProfesor);
                oUpisiPredmet.putExtra("ak_godina", sAkGodina);
                oUpisiPredmet.putExtra("broj_sati", sBrojSati);
                oUpisiPredmet.putExtra("broj_sati_lv", sBrojSatiLV);
                //oUpisiPredmet.putExtra("list",oExtras.getString("list"));
                startActivity(oUpisiPredmet);

            }
        });

    }
}
