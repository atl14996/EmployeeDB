package com.example.week3project;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static java.lang.Double.valueOf;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    ArrayList<Employee> employeeArrayList;

    public MyRecyclerViewAdapter(ArrayList<Employee> employeelist){

        this.employeeArrayList = employeelist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.employee_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Employee currentEmployee = employeeArrayList.get(i);

        viewHolder.tvEmployeeName.setText(currentEmployee.getEmployeeName());
        viewHolder.tvEmployeeBirthday.setText(currentEmployee.getEmployeeBirthdate());
        viewHolder.tvEmployeeWage.setText(valueOf(currentEmployee.getEmployeeWAge()).toString());
        viewHolder.tvEmployeeHireDate.setText(currentEmployee.getEmployeeHireDate());
        Glide.with(viewHolder.itemView.getContext()).load(currentEmployee.getImage()).into(viewHolder.imgEmployee);

    }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvEmployeeName;
        TextView tvEmployeeBirthday;
        TextView tvEmployeeWage;
        TextView tvEmployeeHireDate;
        ImageView imgEmployee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgEmployee = itemView.findViewById(R.id.imvemployee);
            tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
            tvEmployeeBirthday = itemView.findViewById(R.id.tvEmployeeBirthday);
            tvEmployeeWage = itemView.findViewById(R.id.tvEmployeeWage);
            tvEmployeeHireDate = itemView.findViewById(R.id.tvEmployeeHirdData);
        }
    }
}
