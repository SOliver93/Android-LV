package com.example.arcus.laboratorijskevjezbe_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recView = findViewById(R.id.initial);
        List<Object> studentList = generateList();
        initializeRecyclerView(recView,studentList);
    }
    void initializeRecyclerView(RecyclerView recyclerView, List<Object> studentList)
    {
        recyclerView.setAdapter(new MyAdapter(studentList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
    }
    List<Object> generateList(){
        List <Object> list = new ArrayList<>();
        list.add("Studenti");
        list.add(new Student("Saša", "Oliver"));
        list.add(new Student("Ivan", "Ivić"));
        return list;
    };
}