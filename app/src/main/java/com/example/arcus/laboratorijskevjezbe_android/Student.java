package com.example.arcus.laboratorijskevjezbe_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Student extends AppCompatActivity {
    private String sIme;
    private String sPrezime;
    private String sDatum;

    public Student(String ime, String prezime, String datum) {
        sIme = ime;
        sPrezime = prezime;
        sDatum = datum;
    }
}