package com.attra.studentdetailsapp.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.attra.studentdetailsapp.Repository.AppRespository;
import com.attra.studentdetailsapp.Utils.Students;

public class AddStudentViewModel extends AndroidViewModel {
    private AppRespository appRespository;
    public AddStudentViewModel(@NonNull Application application) {
        super(application);
        appRespository=AppRespository.getInstance(application.getApplicationContext());
    }

    public void AddData(Students students){

        appRespository.AddDataToDatabase(students);
    }
}
