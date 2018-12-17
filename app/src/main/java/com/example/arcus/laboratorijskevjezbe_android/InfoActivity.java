package com.example.arcus.laboratorijskevjezbe_android;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.arcus.laboratorijskevjezbe_android.Adapter.FragmentAdapter;

public class InfoActivity extends AppCompatActivity {

    Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        btnEnd = findViewById(R.id.btnEnd);

        /**Ovdje se app crasha
        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { startActivity(new Intent(InfoActivity.this, MainActivity.class));
            }
        });*/
    }
}
