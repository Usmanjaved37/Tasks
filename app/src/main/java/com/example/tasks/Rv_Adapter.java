package com.example.tasks;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rv_Adapter extends RecyclerView.Adapter<Rv_Adapter.ViewHolder>{
    ArrayList<Data_Entity> arrData;
    RecyclerView rv_Items;
    Data_Entity data_entity = new Data_Entity();
    Context context;
    Tasks_DB_Helper tasks_db_helper = Tasks_DB_Helper.getDB(context);

    public Rv_Adapter(ArrayList<Data_Entity> arrData, Context context) {
        this.arrData = arrData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_main , parent , false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

holder.title.setText(arrData.get(position).title);
holder.detail.setText(arrData.get(position).detail);

        // For Update
//        holder.rvcardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iUpdate = new Intent(view.getContext() , Update.class);
//                view.getContext().startActivity(iUpdate);
//
//            }
//        });


        //For Delete
        holder.rvcardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("Delete Task")
                        .setMessage("Are you sure for Delete Task")
                        .setIcon(android.R.drawable.ic_delete)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int id = arrData.get(position).getId();
                                tasks_db_helper.tasksDAO().deleteTask(new Data_Entity(id));
                               arrData.remove(position);
                               notifyDataSetChanged();

                            }

                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();

                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title , detail;
        CardView rvcardView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tv_Ctitle);
        detail = itemView.findViewById(R.id.tv_Cdetail);
        rvcardView = itemView.findViewById(R.id.rv_Card);
    }
}
}
