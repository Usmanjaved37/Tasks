package com.example.tasks;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Data_Entity.class , version = 1)
public abstract class Tasks_DB_Helper extends RoomDatabase {
   public static Tasks_DB_Helper instance;
   public static final String DATABASE_NAME = "TASKS";
   public static synchronized Tasks_DB_Helper getDB(Context context){
if (instance == null){
    instance = Room.databaseBuilder(context , Tasks_DB_Helper.class , DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build();
}
return instance;
   }
 public abstract TasksDAO tasksDAO();
}
