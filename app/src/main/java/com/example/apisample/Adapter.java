package com.example.apisample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<EmployeeData> employeelist;
    public Adapter(ArrayList<EmployeeData> employeelist) {
        this.employeelist= employeelist;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_name.setText("Name :"+employeelist.get(position).getEmployee_name());
        holder.tv_salary.setText("Salary :"+employeelist.get(position).getEmployee_salary());
        holder.tv_age.setText("Age :"+employeelist.get(position).getEmployee_age());

    }

    @Override
    public int getItemCount() {
        return employeelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_salary,tv_name,tv_age;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name= itemView.findViewById(R.id.tv_name);
            tv_salary=itemView.findViewById(R.id.tv_salary);
            tv_age=itemView.findViewById(R.id.tv_age);
        }
    }
}
