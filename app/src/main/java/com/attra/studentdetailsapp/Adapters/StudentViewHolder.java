package com.attra.studentdetailsapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.attra.studentdetailsapp.R;
import com.attra.studentdetailsapp.Utils.Students;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView studentNameView,studentemailView,studentAddrView;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        studentNameView=itemView.findViewById(R.id.student_layout_name);
        studentemailView=itemView.findViewById(R.id.student_layout_email);
        studentAddrView=itemView.findViewById(R.id.student_layout_addr);
    }


    public void Populate(final Students students, final StudentAdapter.ListOnClick listOnClick){

        studentNameView.setText(students.getName());
        studentemailView.setText(students.getEmail());
        studentAddrView.setText(students.getAddress());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listOnClick.onItemTap(students);
            }
        });
    }
}
