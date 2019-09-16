package com.attra.studentdetailsapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.attra.studentdetailsapp.Activities.AddStudentActiviy;
import com.attra.studentdetailsapp.Adapters.StudentAdapter;
import com.attra.studentdetailsapp.Utils.Students;
import com.attra.studentdetailsapp.ViewModels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentAdapter studentAdapter;
    private List<Students> studentsList;
    private RecyclerView recyclerView;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.activity_main_recyler_view);
        studentsList=new ArrayList<>();
//        studentsList.add(new Students(1,"Abhishek","send2abhishek","Bangalore"));
//        studentsList.add(new Students(2,"Abhishek Aryan","send2abhishek@live.com","Bangalore"));
//        studentsList.add(new Students(3,"Abhishek Aryan Aryan","send2abhishek","Bangalore"));
            initViewModel();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initViewModel() {

        Observer<List<Students>> dataObserver=new Observer<List<Students>>() {
            @Override
            public void onChanged(@Nullable List<Students> students) {
                studentsList.clear();
                studentsList.addAll(students);

                if(studentAdapter==null){
                    studentAdapter=new StudentAdapter(MainActivity.this,studentsList);
                    recyclerView.setAdapter(studentAdapter);
                }

                else {
                    studentAdapter.notifyDataSetChanged();
                }
            }
        };

        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.getAllStudentsData().observe(MainActivity.this,dataObserver);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.activity_main_menu_add){


            Intent intent=new Intent(this, AddStudentActiviy.class);
            startActivity(intent);

            return true;
        }
        return false;
    }
}
