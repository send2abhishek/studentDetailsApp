package com.attra.studentdetailsapp.Repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import com.attra.studentdetailsapp.Utils.StudentDatabase;
import com.attra.studentdetailsapp.Utils.Students;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRespository {

    private static AppRespository ourInstance;
    private Executor executor= Executors.newSingleThreadExecutor();
    private StudentDatabase studentDatabase;

    public static AppRespository getInstance(Context context){

        return ourInstance=new AppRespository(context);
    }

    private AppRespository(Context context) {

        studentDatabase=StudentDatabase.getInstance(context);

    }

    public void AddDataToDatabase(final Students students){

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    long data=studentDatabase.studentDAO().AddStudents(students);
                    Log.d("Aryan", "run: data inserted"+ data);
                }
            });
    }

    public LiveData<List<Students>> getAllStudents(){

        return studentDatabase.studentDAO().getAllStudents();
    }

    public void delData(final int id){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                int count=studentDatabase.studentDAO().deleteById(id);
                Log.d("Aryan", "data deleted id - "+ count);
            }
        });

    }
}
