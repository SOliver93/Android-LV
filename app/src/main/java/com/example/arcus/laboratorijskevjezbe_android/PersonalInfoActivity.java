package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PersonalInfoActivity extends AppCompatActivity {
    private EditText oImePrezime;
    private String sImePrezime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        oImePrezime = (EditText)findViewById(R.id.etImePrezime);
    }
    public void goToStudentInfo (View view){
        sImePrezime = oImePrezime.getText().toString();
        Intent Upisipredmet = new Intent (this, StudentInfoActivity.class);
        Upisipredmet.putExtra("imePrezime", sImePrezime);
        startActivity(Upisipredmet);
    }
}
