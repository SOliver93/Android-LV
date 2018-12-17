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
import android.widget.EditText;
import android.widget.TextView;

import com.example.arcus.laboratorijskevjezbe_android.listeners.ClassListener;
import com.example.arcus.laboratorijskevjezbe_android.listeners.PracticeListener;
import com.example.arcus.laboratorijskevjezbe_android.listeners.ProffesorListener;
import com.example.arcus.laboratorijskevjezbe_android.listeners.StudentInfoDataSource;
import com.example.arcus.laboratorijskevjezbe_android.listeners.SubjectListener;
import com.example.arcus.laboratorijskevjezbe_android.listeners.YearListener;
import com.example.arcus.laboratorijskevjezbe_android.model.Student;
import com.example.arcus.laboratorijskevjezbe_android.R;

public class FragmentStudentInfo extends Fragment {
    private static final String EXTRA_NAME =  "EXTRA_NAME";
    private static final String EXTRA_LAST_NAME =  "EXTRA_LAST_NAME";
    public static FragmentStudentInfo newInstance() {

        Bundle args = new Bundle();
        FragmentStudentInfo fragment = new FragmentStudentInfo();
        fragment.setArguments(args);
        return fragment;
    }

    public StudentInfoDataSource dataSource;
    TextView tvIme;
    TextView tvPrezime;

    public SubjectListener subjectListener;
    public ProffesorListener profesorListener;
    public YearListener yearListener;
    public ClassListener classListener;
    public PracticeListener practiceListener;
    EditText etStudij, etProfesor, etGodina, etPredavanja, etVjezbe ;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_student_info, container, false);
        etStudij =  view.findViewById(R.id.etKolegij);
        etStudij.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (subjectListener != null) {
                    subjectListener.setSubject(s.toString());
                }

            }
        });
        etProfesor =  view.findViewById(R.id.etProfesor);
        etProfesor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (profesorListener != null) {
                    profesorListener.setProffesor(s.toString());
                }

            }
        });
        etGodina =  view.findViewById(R.id.etGodina);
        etGodina.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (yearListener != null) {
                    yearListener.setYear(s.toString());
                }

            }
        });
        etPredavanja =  view.findViewById(R.id.etPredavanja);
        etPredavanja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (classListener != null) {
                    classListener.setClass(s.toString());
                }

            }
        });
        etVjezbe =  view.findViewById(R.id.etVjezbe);
        etVjezbe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (practiceListener != null) {
                    practiceListener.setPractice(s.toString());
                }

            }
        });
        tvIme = view.findViewById(R.id.tvIme);
        tvPrezime = view.findViewById(R.id.tvPrezime);
        return view;
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            if(dataSource != null){
                Student student = dataSource.getStudent();

                if(student != null){
                    setupTextViews(student);
                }
            }
        }
    }
    private void setupTextViews(Student student){
        tvIme.setText(student.getName());
        tvPrezime.setText(student.getSurname());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        classListener = null;
        subjectListener = null;
        profesorListener = null;
        practiceListener = null;
        yearListener =  null;
    }
}
