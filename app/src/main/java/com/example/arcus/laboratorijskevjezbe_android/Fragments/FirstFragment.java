package com.example.arcus.laboratorijskevjezbe_android.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TextInputLayout;
import com.example.arcus.laboratorijskevjezbe_android.R;

public class FirstFragment extends Fragment {
    public static FirstFragment newInstance(String firstName, String lastName){
        FirstFragment fragment = new FirstFragment();
        Bundle extras = new Bundle();
        extras.putString("firstName", firstName);
        extras.putString("lastName", lastName);
        fragment.setArguments(extras);
        return fragment;
    }
    TextInputLayout tilName;
    TextInputLayout tilLastname;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_student_info, container, false);
        tilName = view.findViewById(R.id.tlIme);
        tilLastname = view.findViewById(R.id.tlPrezime);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}