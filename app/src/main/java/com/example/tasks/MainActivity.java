package com.example.tasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
RecyclerView rv_Items;
    ArrayList<Data_Entity> arrData;
    TasksDAO tasksDAO;

FloatingActionButton btn_LoadIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_LoadIntent = findViewById(R.id.btn_LoadIntent);
        rv_Items = findViewById(R.id.recyclerLayout_items);

        rv_Items.setLayoutManager(new LinearLayoutManager(this ));

        Tasks_DB_Helper tasks_db_helper = Tasks_DB_Helper.getDB(MainActivity.this);
        btn_LoadIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent iNext =  new Intent(MainActivity.this , Add_Tasks.class);
            startActivity(iNext);
            finish();
            }
        });


        arrData = (ArrayList<Data_Entity>) tasks_db_helper.tasksDAO().getAllData();
        Rv_Adapter adapter = new Rv_Adapter(arrData , MainActivity.this);
        rv_Items.setAdapter(adapter);
        Collections.reverse(arrData);
        adapter.notifyItemRangeInserted(0 , arrData.size());
        rv_Items.scrollToPosition(arrData.size() - 1);

    }
}