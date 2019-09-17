package com.attra.studentdetailsapp.Utils;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long AddStudents(Students students);

    @Query("select * from Student_table")
    LiveData<List<Students>> getAllStudents();

    @Query("DELETE FROM Student_table where Student_table_id= :id ")
    int deleteById(int id);

    @Update
    int update(Students students);



}
