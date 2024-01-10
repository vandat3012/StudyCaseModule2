package model;

import model.Employee;


public class EmployeePartTime extends Employee {

    private int hourWork;
    private int salaryInHour;

    public EmployeePartTime() {
    }

    public EmployeePartTime(int hourWork, int salaryInHour) {
        this.hourWork = hourWork;
        this.salaryInHour = salaryInHour;
    }

    public EmployeePartTime(String id, String name, int age, String gender, String email, String nationality, int hourWork, int salaryInHour) {
        super(id, name, age, gender, email, nationality);
        this.hourWork = hourWork;
        this.salaryInHour = salaryInHour;
    }

    public int getHourWork() {
        return hourWork;
    }

    public void setHourWork(int hourWork) {
        this.hourWork = hourWork;
    }

    public int getSalaryInHour() {
        return salaryInHour;
    }

    public void setSalaryInHour(int salaryInHour) {
        this.salaryInHour = salaryInHour;
    }

    @Override
    public double getSalary() {
        return getSalaryInHour() * getHourWork();
    }
}
