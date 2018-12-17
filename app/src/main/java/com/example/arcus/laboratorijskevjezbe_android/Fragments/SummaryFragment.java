package com.example.arcus.laboratorijskevjezbe_android.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.arcus.laboratorijskevjezbe_android.Listeners.SummaryDataSource;
import com.example.arcus.laboratorijskevjezbe_android.Models.Student;
import com.example.arcus.laboratorijskevjezbe_android.R;

public class SummaryFragment extends Fragment {

    public static SummaryFragment newInstance(){
        Bundle args = new Bundle();
        SummaryFragment fragment = new SummaryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SummaryDataSource dataSource;
    TextView tvIme;
    TextView tvPrezime;
    TextView tvDatum;
    TextView tvPredmet;
    TextView tvProfesor;
    TextView tvGodina;
    TextView tvPredavanja;
    TextView tvEcts;
    TextView tvLv;
    Button btnKraj;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary_layout,container,false);
        tvIme = view.findViewById(R.id.txtIme);
        tvPrezime = view.findViewById(R.id.txtPrezime);
        tvDatum = view.findViewById(R.id.datumRod);
        tvPredmet = view.findViewById(R.id.nazivPredmet);
        tvProfesor = view.findViewById(R.id.profIme);
        tvGodina = view.findViewById(R.id.akademskaGodina);
        tvPredavanja = view.findViewById(R.id.predavanjaBroj);
        tvEcts = view.findViewById(R.id.ectsBroj);
        tvLv = view.findViewById(R.id.lvBroj);
        btnKraj = view.findViewById(R.id.btnEnd);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            if(dataSource != null){
                Student student = dataSource.getStudent();
                if (student != null){
                    setupTextViews(student);
                }
            }
        }
    }

    private void setupTextViews(Student student){
        tvIme.setText(student.getIme());
        tvPrezime.setText(student.getPrezime());
        tvDatum.setText(student.getDatum());
        tvGodina.setText(student.getGodina());
        tvPredavanja.setText(student.getPredavanja());
        tvPredmet.setText(student.getPredmet());
        tvProfesor.setText(student.getProfesor());
        tvEcts.setText(student.getECTS());
        tvLv.setText(student.getLV());
    }
}