package com.example.arcus.laboratorijskevjezbe_android.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.arcus.laboratorijskevjezbe_android.Listeners.StudentInfoListener;
import com.example.arcus.laboratorijskevjezbe_android.Models.Course;
import com.example.arcus.laboratorijskevjezbe_android.Models.CoursesResponse;
import com.example.arcus.laboratorijskevjezbe_android.Models.Instructor;
import com.example.arcus.laboratorijskevjezbe_android.Network.RetrofitManager;
import com.example.arcus.laboratorijskevjezbe_android.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CoursesResponse>, AdapterView.OnItemSelectedListener {
    public static StudentInfoFragment newInstance(){
        Bundle args = new Bundle();

        StudentInfoFragment fragment = new StudentInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public StudentInfoListener studentInfoListener;

    EditText etGodina;
    EditText etECTS;
    EditText etPredavanja;
    EditText etLV;

    private Spinner spPredmet;
    private Spinner spProfesor;

    ArrayList<String> predmeti = new ArrayList<String>();
    ArrayList<String> profesori = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_info_layout,container,false);

        etGodina = view.findViewById(R.id.editGodina);
        etECTS = view.findViewById(R.id.editECTS);
        etPredavanja = view.findViewById(R.id.editPred);
        etLV = view.findViewById(R.id.editLV);

        spPredmet = view.findViewById(R.id.spinnerPredmet);
        spProfesor = view.findViewById(R.id.spinnerProfesor);

        predmeti.add("Odaberite predmet");
        profesori.add("Odaberite profesora");

        ArrayAdapter<String> predmetAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, predmeti);
        predmetAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spPredmet.setAdapter(predmetAdapter);
        spPredmet.setOnItemSelectedListener(this);

        ArrayAdapter<String> profesorAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, profesori);
        profesorAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spProfesor.setAdapter(profesorAdapter);
        spProfesor.setOnItemSelectedListener(this);

        Call<CoursesResponse> callResponse = RetrofitManager.getInstance().service().getCourses();
        callResponse.enqueue(this);

        etECTS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                studentInfoListener.setECTS(etECTS.getText().toString());

            }
        });

        etGodina.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                studentInfoListener.setGodina(etGodina.getText().toString());

            }
        });

        etPredavanja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                studentInfoListener.setPredavanja(etPredavanja.getText().toString());

            }
        });

        etLV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                studentInfoListener.setLV(etLV.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        studentInfoListener = null;
    }


    @Override
    public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response) {
        String predmet;
        String profesor;

        if(response.isSuccessful() && response.body()!=null){
            predmet = response.body().getCourses().toString();
            profesor = response.body().getCourses().toString();

            for(Course courses : response.body().getCourses()){
                for(Instructor instructor : courses.getInstructors()){
                    predmeti.add(courses.getTitle());
                    profesori.add(instructor.getName());
                }
            }
        }

        else{
            predmet = "Greška";
            profesor = "Greška";
        }
    }

    @Override
    public void onFailure(Call<CoursesResponse> call, Throwable t) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      int  spinner_predmet = R.id.spinnerPredmet;
      int spinner_profesor = R.id.spinnerProfesor;

        if(parent.getId()== spinner_predmet){
            String predmet = parent.getItemAtPosition(position).toString();
            if(studentInfoListener != null){
                studentInfoListener.setPredmet(predmet);
            }
        }
        else if(parent.getId() == spinner_profesor){
            String profesor = parent.getItemAtPosition(position).toString();
            if(studentInfoListener != null){
                studentInfoListener.setProfesor(profesor);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
