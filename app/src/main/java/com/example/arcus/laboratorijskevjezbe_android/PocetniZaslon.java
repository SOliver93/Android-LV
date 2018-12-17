package com.example.arcus.laboratorijskevjezbe_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.arcus.laboratorijskevjezbe_android.adapter.MainRecyclerViewAdapter;
import com.example.arcus.laboratorijskevjezbe_android.model.Student;

import java.util.ArrayList;
import java.util.List;

public class PocetniZaslon extends AppCompatActivity {
    private Spinner LangSpinner;
    private Button oNewStud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetni_zaslon);

        //RecyclerView popunjavanje
        RecyclerView recView = findViewById(R.id.initial);
        List<Object> studentList = generateList();
        initializeRecyclerView(recView,studentList);

       // Spinner popunjavanje, adapter
        LangSpinner =(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.langagues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LangSpinner.setAdapter(adapter);

        //Button new activity
        oNewStud = (Button) findViewById(R.id.btnNew);
        oNewStud.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(PocetniZaslon.this, InfoActivity.class);
                PocetniZaslon.this.startActivity(myIntent);
            }
        });
    }
    void initializeRecyclerView(RecyclerView recyclerView, List<Object> studentList)
    {
       recyclerView.setAdapter(new MainRecyclerViewAdapter(studentList));
       recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
    }
    List<Object> generateList(){
        List <Object> list = new ArrayList<>();
        String naslov = getResources().getString(R.string.title);
        list.add(naslov);
        list.add(new Student("Sasa", "Oliver"));
        list.add(new Student("Marko", "Markic"));
        list.add(new Student("Ivan", "Ivanovic"));
        return list;
    }
    @Override
    public void onBackPressed() {

    }
}
