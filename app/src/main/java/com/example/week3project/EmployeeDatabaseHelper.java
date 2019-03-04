package com.example.week3project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Locale;

import static com.example.week3project.EmployeeDatabaseContract.COLUMN_BIRTHDATE;
import static com.example.week3project.EmployeeDatabaseContract.COLUMN_HIREDATE;
import static com.example.week3project.EmployeeDatabaseContract.COLUMN_IMAGE;
import static com.example.week3project.EmployeeDatabaseContract.COLUMN_NAME;
import static com.example.week3project.EmployeeDatabaseContract.COLUMN_WAGE;
import static com.example.week3project.EmployeeDatabaseContract.DATABASE_VERSION;
import static com.example.week3project.EmployeeDatabaseContract.TABLE_NAME;
import static com.example.week3project.EmployeeDatabaseContract.createQuery;
import static com.example.week3project.EmployeeDatabaseContract.getWhereClauseByName;

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {


    public EmployeeDatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertEmployeeIntoDatabase(@NonNull Employee employee) {

        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        //Data holder used for database key value pairs
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, employee.getEmployeeName());
        contentValues.put(COLUMN_BIRTHDATE, employee.getEmployeeBirthdate());
        contentValues.put(COLUMN_WAGE, employee.getEmployeeWAge());
        contentValues.put(COLUMN_HIREDATE, employee.getEmployeeHireDate());
        contentValues.put(COLUMN_IMAGE, employee.getImage());

        //insert the car into the table using contentValues

        return writeableDatabase.insert(TABLE_NAME, null, contentValues);


    }

    public static String getAllEmployeesQuery(){
        return "SELECT * FROM" + TABLE_NAME;

    }

    public ArrayList<Employee> getAllEmployeesFromDatabase() {

        ArrayList<Employee> returnEmployeeList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Cursor cursor = readableDatabase.rawQuery(getAllEmployeesQuery(), null);

        if(cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String hireDate = cursor.getString(cursor.getColumnIndex(COLUMN_HIREDATE));
                String birthDate = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDATE));
                double wage = cursor.getDouble(cursor.getColumnIndex(COLUMN_WAGE));
                String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));



                returnEmployeeList.add(new Employee(name, birthDate, wage, hireDate, image));
            }
            while (cursor.moveToNext());
            //return the result in a list
        }
        cursor.close();
        return returnEmployeeList;
    }

    public Employee getEmployeebyName(String name) {

        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Employee returnEmployee = new Employee();

        //cursor to hold results

        Cursor cursor = readableDatabase.rawQuery(EmployeeDatabaseContract.getEmployeebyName(name), null);
        if(cursor.moveToFirst()) {
            String namefromDB = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String birthday = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDATE));
            double wage = cursor.getDouble(cursor.getColumnIndex(COLUMN_WAGE));
            String hireDate = cursor.getString(cursor.getColumnIndex(COLUMN_HIREDATE));
            String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));




            returnEmployee = new Employee(namefromDB, birthday, wage, hireDate, image);
        }
        cursor.close();
        return returnEmployee;

    }

    //update an item in the database

    public long updateEmployeeInDatabase(@NonNull Employee employee) {


        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        //Data holder used for database key value pairs
        ContentValues contentValues = new ContentValues();

          contentValues.put(COLUMN_NAME, employee.getEmployeeName());
          contentValues.put(COLUMN_BIRTHDATE, employee.getEmployeeBirthdate());
          contentValues.put(COLUMN_WAGE, employee.getEmployeeWAge());
          contentValues.put(COLUMN_HIREDATE, employee.getEmployeeHireDate());
          contentValues.put(COLUMN_IMAGE, employee.getImage());

        String whereClause = String.format(Locale.US, "WHERE %s = \"%s\"", COLUMN_NAME, employee.getEmployeeName());

        return writeableDatabase.update(TABLE_NAME, contentValues,
                getWhereClauseByName(),
                new String[]{String.valueOf(employee.getEmployeeName())});


    }

    //delete entry or entries from the database

    public long deleteFromDatabaseByName(String[] name) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();



        return sqLiteDatabase.delete(TABLE_NAME, getWhereClauseByName() + name[0], null);





    }

}
