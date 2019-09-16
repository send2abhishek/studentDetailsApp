package com.attra.studentdetailsapp.Utils;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Student_table")
public class Students {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Student_table_id")
    private int id;

    @ColumnInfo(name ="Student_table_name")
    private String name;

    @ColumnInfo(name = "Student_table_email")
    private String email;

    @ColumnInfo(name = "Student_table_address")
    private String address;


    public Students( String name, String email, String address) {

        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
