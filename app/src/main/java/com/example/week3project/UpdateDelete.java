package com.example.week3project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class UpdateDelete extends Fragment implements View.OnClickListener {
TextView tvemployeename;
TextView tvemployeeBirthDate;
TextView tvemployeeWage;
TextView tvemployeeHireDate;
ImageView ivemployeeImage;
EditText etEnterEmployeeName;
EditText etEmployeeBirthday;
EditText etEmployeeWage;
EditText etEmployeeHireDate;
EditText etEmployeeImage;
Button btnSearchForEmployee;
Button btnDeleteEmployee;
Button btnUpdate;
Button btnUpdateinDatabase;
FrameLayout updateEmployee;
EmployeeDatabaseHelper employeeDatabaseHelper;
TextView tvemployeeInfo;


    private OnFragmentInteractionListener mListener;

    public UpdateDelete() {
        // Required empty public constructor
    }


    public static UpdateDelete newInstance() {
        UpdateDelete fragment = new UpdateDelete();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_delete, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvemployeename = view.findViewById(R.id.tvEditName);
        tvemployeeBirthDate = view.findViewById(R.id.tvEditBirthday);
        tvemployeeWage = view.findViewById(R.id.tvEditWage);
        tvemployeeHireDate = view.findViewById(R.id.tvEditHireDate);
        ivemployeeImage = view.findViewById(R.id.imgEditImage);
        etEnterEmployeeName = view.findViewById(R.id.etEnterNametoUpdate);
        etEmployeeBirthday = view.findViewById(R.id.etUpdateEmployeeBirthday);
        etEmployeeWage = view.findViewById(R.id.etUpdateEmployeeWage);
        etEmployeeHireDate = view.findViewById(R.id.etUpdateEmployeeHireDate);
        etEmployeeImage = view.findViewById(R.id.etUpdateEmployeeImage);
        btnSearchForEmployee = view.findViewById(R.id.btnSearchforEmployee);
        btnDeleteEmployee = view.findViewById(R.id.btnDeleteEmployee);
        btnUpdate = view.findViewById(R.id.btnUpdateButton);
        btnUpdateinDatabase = view.findViewById(R.id.btnUpdateInDatabase);
        btnSearchForEmployee.setOnClickListener(this);
        btnDeleteEmployee.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnUpdateinDatabase.setOnClickListener(this);
        updateEmployee = view.findViewById(R.id.frmUpdate);
        updateEmployee.setVisibility(View.GONE);
        tvemployeeInfo = view.findViewById(R.id.tvEmployeeInfo);


    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
switch (v.getId()) {

    case R.id.btnUpdateButton:
        if(tvemployeename.getText().toString() != null) {
            updateEmployee.setVisibility(View.VISIBLE);
            tvemployeeInfo.setText(tvemployeename.toString());
        }
        break;

    case R.id.btnSearchforEmployee:
        String searchParam = etEnterEmployeeName.getText().toString();
        Employee singleEmployee = employeeDatabaseHelper.getEmployeebyName(searchParam);
        tvemployeename.setText(singleEmployee.getEmployeeName());
        tvemployeeBirthDate.setText(singleEmployee.getEmployeeBirthdate());
        tvemployeeWage.setText(String.valueOf(singleEmployee.getEmployeeWAge()));
        tvemployeeHireDate.setText(singleEmployee.getEmployeeHireDate());
        tvemployeeInfo.setText(tvemployeename.toString());
        Glide.with(getContext()).load(ivemployeeImage);

        break;

    case R.id.btnDeleteEmployee:
        String[] deleteEmployee = new String[] {tvemployeeInfo.getText().toString()};
        employeeDatabaseHelper.deleteFromDatabaseByName(deleteEmployee);

        break;

        case R.id.btnUpdateInDatabase:
            String name = tvemployeeInfo.getText().toString();
            String birthdate = etEmployeeBirthday.getText().toString();
            Double wage = Double.valueOf(etEmployeeWage.getText().toString());
            String hiredate = etEmployeeHireDate.getText().toString();
            String image = etEmployeeImage.getText().toString();

            Employee updatedEmployee = new Employee(name, birthdate, wage, hiredate, image);
            employeeDatabaseHelper.updateEmployeeInDatabase(updatedEmployee);

            break;
}


    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
