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

import com.example.arcus.laboratorijskevjezbe_android.listeners.DateListener;
import com.example.arcus.laboratorijskevjezbe_android.listeners.FirstNameListener;
import com.example.arcus.laboratorijskevjezbe_android.listeners.LastNameListener;
import com.example.arcus.laboratorijskevjezbe_android.R;

public class FragmentPersonalInfo extends Fragment
{
    public static FragmentPersonalInfo newInstance() {

        Bundle args = new Bundle();
        FragmentPersonalInfo fragment = new FragmentPersonalInfo();
        fragment.setArguments(args);
        return fragment;
    }
    public FirstNameListener Listener;
    public LastNameListener nameListener;
    public DateListener dateListener;
    EditText etIme, etPrezime, etDatum ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_personal_info, container, false);
        etIme =  view.findViewById(R.id.etIme);
        etIme.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Listener != null) {
                    Listener.setFirstName(s.toString());
                }

            }
        });
        etPrezime =  view.findViewById(R.id.etPrezime);
        etPrezime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (nameListener != null) {
                    nameListener.setLastName(s.toString());
                }

            }
        });
        etDatum =  view.findViewById(R.id.etDatum);
        etDatum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dateListener != null) {
                    dateListener.setDate(s.toString());
                }

            }
        });
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        nameListener = null;
        dateListener = null;
        Listener = null;
    }
}
