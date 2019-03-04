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


        package com.example.week3project;

public class Employee {

    private String employeeName;
    private String employeeBirthdate;
    private double employeeWAge;
    private String employeeHireDate;
    private String image;


    public Employee(){



    }
    public Employee(String employeeName, String employeeBirthdate, double employeeWAge, String employeeHireDate, String image) {
        this.employeeName = employeeName;
        this.employeeBirthdate = employeeBirthdate;
        this.employeeWAge = employeeWAge;
        this.employeeHireDate = employeeHireDate;
        this.image = image;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public void setEmployeeBirthdate(String employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public double getEmployeeWAge() {
        return employeeWAge;
    }

    public void setEmployeeWAge(double employeeWAge) {
        this.employeeWAge = employeeWAge;
    }

    public String getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


