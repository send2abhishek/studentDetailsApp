package com.attra.studentdetailsapp.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.attra.studentdetailsapp.R;
import com.attra.studentdetailsapp.Utils.Students;
import com.attra.studentdetailsapp.ViewModels.AddStudentViewModel;

public class AddStudentActiviy extends AppCompatActivity implements View.OnClickListener {

    private EditText name,email,address;
    private Button savebtn;
    private AddStudentViewModel addStudentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_activiy);
        name=findViewById(R.id.add_student_name);
        email=findViewById(R.id.add_student_email);
        address=findViewById(R.id.add_student_address);
        savebtn=findViewById(R.id.add_student_save_btn);
        addStudentViewModel= ViewModelProviders.of(this).get(AddStudentViewModel.class);
        savebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(this,"Student Details Will added soon",Toast.LENGTH_SHORT).show();

        addStudentViewModel.AddData(new Students(name.getText().toString(),email.getText().toString(),
                address.getText().toString()));
    }
}
