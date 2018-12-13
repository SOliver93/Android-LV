package com.example.arcus.laboratorijskevjezbe_android.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arcus.laboratorijskevjezbe_android.R;

public class FragmentSummary extends Fragment {
    public static FragmentSummary newInstance() {

        Bundle args = new Bundle();
        FragmentSummary fragment = new FragmentSummary();
        fragment.setArguments(args);
        return fragment;
    }
    TextView tvIme, tvPrezime, tvDatum, tvStudij, tvProfesor, tvGodina, tvPredavanja, tvVjezbe;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_summary, container, false);

        tvIme = view.findViewById(R.id.tvIme);
        tvPrezime = view.findViewById(R.id.tvPrezime);
        tvDatum = view.findViewById(R.id.tvDatum);
        tvStudij =  view.findViewById(R.id.tvKolegij);
        tvProfesor =  view.findViewById(R.id.tvProfesor);
        tvGodina =  view.findViewById(R.id.tvGodina);
        tvPredavanja =  view.findViewById(R.id.tvPredavanja);
        tvVjezbe =  view.findViewById(R.id.tvVjezbe);
        return view;
    }
}
