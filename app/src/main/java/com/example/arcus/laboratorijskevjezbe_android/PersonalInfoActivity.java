package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInfoActivity extends AppCompatActivity {

private Button oBtnPersonal;
private EditText oIme;
private EditText oPrezime;
private EditText oRodenje;
private String sIme;
private String sPrezime;
private String sRodenje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        oBtnPersonal = (Button)findViewById(R.id.btnPersonal);
        oIme = (EditText)findViewById(R.id.editIme);
        oPrezime = (EditText)findViewById(R.id.editPrezime);
        oRodenje = (EditText)findViewById(R.id.editRodenje);


        oBtnPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sIme = oIme.getText().toString();
                sPrezime = oPrezime.getText().toString();
                sRodenje = oRodenje.getText().toString();

                Intent oStudentInfoIntent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oStudentInfoIntent.putExtra("ime",sIme);
                oStudentInfoIntent.putExtra("prezime",sPrezime);
                oStudentInfoIntent.putExtra("rodenje",sRodenje);
                startActivity(oStudentInfoIntent);
            }
        });

    }

}


