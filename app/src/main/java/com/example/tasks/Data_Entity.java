package com.example.tasks;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "Tasks")
public class Data_Entity {

   @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo (name =  "title")
    String title;
    @ColumnInfo(name = "detail")
    String detail;

    public Data_Entity(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Ignore
    public Data_Entity(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }
    public Data_Entity(){

    }
    public int getId() {
        return id;
    }
}
