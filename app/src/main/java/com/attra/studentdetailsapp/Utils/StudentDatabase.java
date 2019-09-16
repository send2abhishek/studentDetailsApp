package com.attra.studentdetailsapp.Utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Students.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public static final String DATABASE_NAME="students.db";

    public static volatile StudentDatabase instance;

    private static final Object LOCK=new Object();

    public abstract StudentDAO studentDAO();

    public static StudentDatabase getInstance(Context context){

        if(instance==null){

            synchronized (LOCK){

                if(instance==null){

                    instance= Room.databaseBuilder(context.getApplicationContext(),
                            StudentDatabase.class,DATABASE_NAME).build();
                }
            }
        }

        return instance;
    }
}
