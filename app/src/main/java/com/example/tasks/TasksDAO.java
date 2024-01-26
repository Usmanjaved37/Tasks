package com.example.tasks;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TasksDAO {

    @Query("SELECT * FROM Tasks")
    public List<Data_Entity> getAllData();

    @Delete
    void deleteTask(Data_Entity data_entity);
    @Insert
    void insertTask(Data_Entity data_entity);
    @Update
    void updateTask(Data_Entity data_entity);


}
