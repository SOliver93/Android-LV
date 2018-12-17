package com.example.arcus.laboratorijskevjezbe_android;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static final int TYPE_HEADER = 0;
    static final int TYPE_STUDENT = 1;

    private List<Object> dataList;

    MainRecyclerViewAdapter(List<Object>dataList){
        this.dataList=dataList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemViewType) {
        if(itemViewType == TYPE_HEADER){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_layout,viewGroup,false);
            return new HeaderViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_layout,viewGroup,false);
            return new StudentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        Object data = dataList.get(position);
        if(viewHolder instanceof HeaderViewHolder && data instanceof String ){
            String headerTitle = (String) data;
            ((HeaderViewHolder)viewHolder).tvHeaderLabel.setText(headerTitle);
        }
        else if(viewHolder instanceof StudentViewHolder && data instanceof Student){
            Student student = (Student) data;
            ((StudentViewHolder)viewHolder).tvStudentName.setText(student.getName());
            ((StudentViewHolder) viewHolder).tvStudentSurname.setText(student.getLastName());

        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position){
        if(dataList.get(position) instanceof String){
            return TYPE_HEADER;
        }
        else{
            return TYPE_STUDENT;
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{

        TextView tvHeaderLabel;
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeaderLabel = itemView.findViewById(R.id.tvHeaderTitle);
        }
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView tvStudentName;
        TextView tvStudentSurname;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
            tvStudentSurname = itemView.findViewById(R.id.tvStudentSurname);
        }
    }
}
