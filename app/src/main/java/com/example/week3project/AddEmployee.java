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

public class AddEmployee extends Fragment implements View.OnClickListener {

    EditText etaddEmployeeName;
    EditText etaddEmployeeBirthday;
    EditText etAddEmployeeWage;
    EditText etAddEmployeeHireDate;
    EditText etAddEmployeeImage;
    Button btnAddEmployee;
    EmployeeDatabaseHelper employeeDatabaseHelper;

    private OnFragmentInteractionListener mListener;

    public AddEmployee() {
        // Required empty public constructor
    }


    public static AddEmployee newInstance() {
        AddEmployee fragment = new AddEmployee();

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
        return inflater.inflate(R.layout.fragment_add_employee, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etaddEmployeeName = view.findViewById(R.id.etAddEmployeeName);
        etaddEmployeeBirthday = view.findViewById(R.id.etAddEmployeeBirthday);
        etAddEmployeeWage = view.findViewById(R.id.etAddEmployeeWage);
        etAddEmployeeHireDate = view.findViewById(R.id.etAddEmployeeHireDate);
        etAddEmployeeImage = view.findViewById(R.id.etAddEmployeeImage);
        btnAddEmployee = view.findViewById(R.id.btnAddEmployee);
        btnAddEmployee.setOnClickListener(this);


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


String inputName = etaddEmployeeName.getText().toString();
String inputbirthday = etaddEmployeeBirthday.getText().toString();
double inputWage = Double.valueOf(etAddEmployeeWage.getText().toString());
String inputHireDate = etAddEmployeeHireDate.getText().toString();
String imagelocation = etAddEmployeeImage.getText().toString();

        Employee newEmployee = new Employee(inputName, inputbirthday, inputWage, inputHireDate,imagelocation);
employeeDatabaseHelper.insertEmployeeIntoDatabase(newEmployee);
    }


    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
