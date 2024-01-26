package com.example.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Tasks extends AppCompatActivity {
EditText edtTitle , edtDetails;
Button btnAddTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);
        btnAddTask = findViewById(R.id.btn_TasksAdd);
        edtTitle = findViewById(R.id.edt_Title);
        edtDetails = findViewById(R.id.edt_Details);


        Tasks_DB_Helper tasks_db_helper = Tasks_DB_Helper.getDB(Add_Tasks.this);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String title =  edtTitle.getText().toString();
              String details =  edtDetails.getText().toString();

              tasks_db_helper.tasksDAO().insertTask(new Data_Entity(title , details));
                Intent iback = new Intent(Add_Tasks.this , MainActivity.class);
                startActivity(iback);
                finish();
            }
        });

    }

}