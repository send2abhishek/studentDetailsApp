package com.attra.studentdetailsapp.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.attra.studentdetailsapp.Repository.AppRespository;
import com.attra.studentdetailsapp.Utils.Students;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private AppRespository appRespository;
    public MainViewModel(@NonNull Application application) {
        super(application);

        appRespository=AppRespository.getInstance(application.getApplicationContext());
    }


    public void AddData(Students students){

        appRespository.AddDataToDatabase(students);
    }

    public LiveData<List<Students>> getAllStudentsData(){

        return appRespository.getAllStudents();
    }
}
