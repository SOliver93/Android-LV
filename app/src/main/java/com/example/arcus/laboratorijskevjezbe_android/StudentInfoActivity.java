package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class StudentInfoActivity extends AppCompatActivity {
    private EditText oUpisi;
    private String sUpisi;
    private String sStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        oUpisi = (EditText)findViewById(R.id.etKolegij);
        final Bundle oExtras = getIntent().getExtras();
        sStudent = oExtras.getString("imePrezime");
    }

    public void goToSummary (View view){
        sUpisi = oUpisi.getText().toString();
        Intent Summary = new Intent (this, SummaryActivity.class);
        Summary.putExtra("kolegij", sUpisi);
        Summary.putExtra("student", sStudent);
        startActivity(Summary);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        return (keyCode == KeyEvent.KEYCODE_BACK ? true : super.onKeyDown(keyCode, event));
    }
}
