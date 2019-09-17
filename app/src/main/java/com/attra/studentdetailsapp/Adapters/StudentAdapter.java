package com.attra.studentdetailsapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attra.studentdetailsapp.R;
import com.attra.studentdetailsapp.Utils.Students;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private Context context;
    private List<Students> studentsList;
    private LayoutInflater inflater;
    private ListOnClick listOnClick;

    public StudentAdapter(Context context, List<Students> studentsList, ListOnClick listOnClick) {
        this.context = context;
        this.studentsList = studentsList;
        inflater=LayoutInflater.from(context);
        this.listOnClick=listOnClick;

    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.student_view_layout,viewGroup,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int pos) {

        Students students=studentsList.get(pos);
        studentViewHolder.Populate(students,listOnClick);
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }


   public interface ListOnClick{

        void onItemTap(Students students);
   }
}
