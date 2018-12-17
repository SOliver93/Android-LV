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

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button oBtnStudent;
    private Spinner oSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      RecyclerView recView = findViewById(R.id.recyclerView);
      List<Object>studentList = generateList();
      initializeRecyclerView(recView, studentList);

        oSpinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.jezik_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        oSpinner.setAdapter(adapter);



        oBtnStudent = (Button)findViewById(R.id.btnStudent);
        oBtnStudent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PersonalInfoActivity.class));
            }
        });

    }

    List<Object> generateList(){
        List<Object> list = new ArrayList<>();

        list.add("Studenti");
        list.add(new Student("Sasa","Oliver"));
        list.add(new Student("Ivan","Ivanovic"));
        list.add(new Student("Matija","Zeman"));

        return list;
    }

    void initializeRecyclerView(RecyclerView recyclerView,List<Object>studentList){
        recyclerView.setAdapter(new MainRecyclerViewAdapter(studentList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onBackPressed() { }
}
