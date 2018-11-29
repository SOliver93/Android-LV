package com.example.arcus.laboratorijskevjezbe_android;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateNewRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter();
    }
}
