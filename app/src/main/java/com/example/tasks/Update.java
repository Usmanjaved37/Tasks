package com.example.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Update extends AppCompatActivity {

    Rv_Adapter rv_adapter;
    EditText edt_Title , edt_Details;
    Button btn_Update;
    Context context;
    ArrayList<Data_Entity> arrData;
Tasks_DB_Helper tasks_db_helper = Tasks_DB_Helper.getDB(context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        edt_Title = findViewById(R.id.edt_Title);
        edt_Details = findViewById(R.id.edt_Details);
        btn_Update = findViewById(R.id.btn_Update);


        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}