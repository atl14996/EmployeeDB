//a.	employeeName
//        b.	employeeBirthDate
//        c.	employeeWage
//        d.	employeeHireDate
//        e.	employeeImage

package com.example.week3project;

import android.util.Log;

import java.util.Locale;

public class EmployeeDatabaseContract {
    public static final String DATABASE_NAME = "car_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "employees";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_BIRTHDATE = "birthdate";
    public static final String COLUMN_WAGE = "wage";
    public static final String COLUMN_HIREDATE = "hire_date";
    public static final String COLUMN_IMAGE = "image";


    public static String createQuery() {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("CREATE TABLE");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        queryBuilder.append(COLUMN_NAME);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_BIRTHDATE);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_WAGE);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_HIREDATE);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_IMAGE);
        queryBuilder.append(" TEXT ) ");


        Log.d("TAG", "createQuery: " + queryBuilder.toString());




        return queryBuilder.toString();

    }

    public static String getEmployeebyName(String name) {
        return String.format("SELECT * FROM %s WHERE %s = \"%d\"", TABLE_NAME, COLUMN_NAME, name);
        // return "SELECT * FROM" + TABLE_NAME + " WHERE " + COLUMN_ID + " = ";
    }

    public static String getWhereClauseByName(){

        return String.format(Locale.US, "%s = ", COLUMN_NAME);
    }


}

