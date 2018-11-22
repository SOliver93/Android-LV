package com.example.arcus.laboratorijskevjezbe_android;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList mDataset;

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView mStudentIme;
        public TextView mStudentPrezime;

        public StudentViewHolder(View ContentView) {
            super(ContentView);
            mStudentIme = ContentView.findViewById(R.id.tvStudentI);
            mStudentPrezime = ContentView.findViewById(R.id.tvStudentP);
        }
    }

    public static class NaslovViewHolder extends RecyclerView.ViewHolder {
        public TextView mNaslovView;

        public NaslovViewHolder(View tvNaslov) {
            super(tvNaslov);
            mNaslovView = tvNaslov.findViewById(R.id.tvNaslov);
        }
    }

    //konstruktor klase MyAdapter
    public MyAdapter(ArrayList myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 0)
        {
            TextView tvNaslov = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_layout, viewGroup, false);
            NaslovViewHolder vhNaslov = new NaslovViewHolder(tvNaslov);
            return vhNaslov;
        }
        else
        {
            TextView tvStudent = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_layout, viewGroup, false);
            StudentViewHolder vhStudent = new StudentViewHolder(tvStudent);
            return vhStudent;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (position == 0) {
            NaslovViewHolder vh = (NaslovViewHolder) viewHolder;
        }
        else
        {
            StudentViewHolder svh = (StudentViewHolder) viewHolder;
        }

        //if (viewHolder instanceof  StudentViewHolder){
        //}

    }

    //obavezan dio klase, određuje koji je broj elemenata koji se vraća
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}