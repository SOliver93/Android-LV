package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    private String sStudent;
    private String sKolegij;
    private TextView oStudent;
    private TextView oKolegij;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        final Bundle oExtras = getIntent().getExtras();
        sStudent = oExtras.getString("student");
        sKolegij = oExtras.getString("kolegij");
        oStudent = (TextView) findViewById(R.id.tvStudent);
        oStudent.setText(sStudent);
        oKolegij = (TextView) findViewById(R.id.tvKolegij);
        oKolegij.setText(sKolegij);
    }
    public void goToActivity1 (View view){
        Intent Pocetak = new Intent (this, PersonalInfoActivity.class);
        startActivity(Pocetak);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        return (keyCode == KeyEvent.KEYCODE_BACK ? true : super.onKeyDown(keyCode, event));
    }
}