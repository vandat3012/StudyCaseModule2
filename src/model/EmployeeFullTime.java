package model;

import java.time.LocalDate;

public class EmployeeFullTime extends Employee implements Insurance,LongTimeEmployee {
    private LocalDate dayStartWork;
    private int daysWork;
    private int salaryInDays;
    private int overTime;
    private int late;
    public EmployeeFullTime() {
    }


    public EmployeeFullTime(LocalDate dayStartWork, int daysWork, int salaryInDays, int overTime, int late) {
        this.dayStartWork = dayStartWork;
        this.daysWork = daysWork;
        this.salaryInDays = salaryInDays;
        this.overTime = overTime;
        this.late = late;
    }

    public EmployeeFullTime(String id, String name, int age, String gender, String email, String nationality, LocalDate dayStartWork, int daysWork, int salaryInDays, int overTime, int late) {
        super(id, name, age, gender, email, nationality);
        this.dayStartWork = dayStartWork;
        this.daysWork = daysWork;
        this.salaryInDays = salaryInDays;
        this.overTime = overTime;
        this.late = late;
    }

    public LocalDate getDayStartWork() {
        return dayStartWork;
    }

    public void setDayStartWork(LocalDate dayStartWork) {
        this.dayStartWork = dayStartWork;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public int getDaysWork() {
        return daysWork;
    }

    public void setDaysWork(int daysWork) {
        this.daysWork = daysWork;
    }

    public int getSalaryInDays() {
        return salaryInDays;
    }

    public void setSalaryInDays(int salaryInDays) {
        this.salaryInDays = salaryInDays;
    }

    @Override
    public double getSalary() {
        return getSalaryInDays() * getDaysWork() + getOverTime() * getSalaryInDays() / 6 - getLate() * getSalaryInDays() * 0.5;
    }

    @Override
    public double getSalaryAfterIncrease() {
        LocalDate today = LocalDate.now();
        if(today.isBefore(getDayStartWork().minusYears(1)) || today.isEqual(getDayStartWork().minusYears(1)) && today.isAfter(getDayStartWork().minusYears(3))) {
            return getSalary() * 1.3;
        }else if (today.isEqual(getDayStartWork().minusYears(3)) || today.isAfter(getDayStartWork().minusYears(3))) {
            return getSalary() * 1.4;
        }else {
            return getSalary();
        }
    }
    @Override
    public double salaryReality() {
        if (getSalaryAfterIncrease() > 60000000) {
            return getSalaryAfterIncrease() * 0.9;
        }else if (getSalaryAfterIncrease() < 10000000){
            return getSalaryAfterIncrease();
        }else {
            return getSalaryAfterIncrease() * 0.95;
        }
    }

    @Override
    public String toString() {
        return "EmployeeFullTime{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", nationality='" + getNationality() + '\'' +
                "dayStartWork=" + dayStartWork +
                ", daysWork=" + daysWork +
                ", salaryInDays=" + salaryInDays +
                ", overTime=" + overTime +
                ", late=" + late +
                '}';
    }
}
