//************** Weekend 3 Homework ***********************
//        1.	Create an sql database that holds the following information:
//        a.	employeeName
//        b.	employeeBirthDate
//        c.	employeeWage
//        d.	employeeHireDate
//        e.	employeeImage
//        2.	Create an application with 3 fragments
//        a.	First fragment will have a recycler view that will display all entries
//        b.	Second Fragment will insert a new employee
//        c.	Third Fragment will allow for finding an single employee, Updating that employee’s info, or deleting the employee
//        3.	Create a way to navigate between each fragment
//        4.	Use Glide for the images
//

        package com.example.week3project;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements AddEmployee.OnFragmentInteractionListener, RVFragment.OnFragmentInteractionListener, UpdateDelete.OnFragmentInteractionListener {
Button btnAddEmployee;
Button btnUpdateDelete;
FrameLayout recyclerViewFrame;
FrameLayout UpdateDelete;
FrameLayout Insert;
FragmentManager fragmentManager;
public static final String UPDATE_FRAGMENT_TAG = "A";
public static final String ADD_FRAGMENT_TAG = "B";
public static final String RECYCLER_VIEW_FRAGMENT_TAG = "C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UpdateDelete = findViewById(R.id.frmEditUpdateDelete);
        Insert = findViewById(R.id.frmInsertEmployee);
        recyclerViewFrame = findViewById(R.id.frmRVAllEntries);
        UpdateDelete.setVisibility(View.GONE);
        Insert.setVisibility(View.GONE);
        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        btnUpdateDelete = findViewById(R.id.btnUpdateDelete);

        fragmentManager.beginTransaction().replace(R.id.frmEditUpdateDelete, com.example.week3project.UpdateDelete.newInstance()).addToBackStack(UPDATE_FRAGMENT_TAG).commit();
        fragmentManager.beginTransaction().replace(R.id.frmInsertEmployee, AddEmployee.newInstance()).addToBackStack(ADD_FRAGMENT_TAG).commit();
        fragmentManager.beginTransaction().replace(R.id.frmRVAllEntries, RVFragment.newInstance()).addToBackStack(RECYCLER_VIEW_FRAGMENT_TAG).commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick (View v)  {

        switch (v.getId()) {

            case R.id.btnAddEmployee:
                      recyclerViewFrame.setVisibility(View.GONE);
                      Insert.setVisibility(View.VISIBLE);
                break;

            case R.id.btnUpdateDelete:
                     recyclerViewFrame.setVisibility(View.GONE);
                     UpdateDelete.setVisibility(View.VISIBLE);
                break;
        }


    }
}
