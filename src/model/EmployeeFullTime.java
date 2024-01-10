package model;

import java.time.LocalDate;

public class EmployeeFullTime extends Employee implements Insurance,LongTimeEmployee {
    private LocalDate dayStartWork;
    private int daysWork;
    private int salaryInDays;
    private double bonus;
    private double fine;
    public EmployeeFullTime() {
    }


    public EmployeeFullTime(LocalDate dayStartWork, int daysWork, int salaryInDays, double bonus, double fine) {
        this.dayStartWork = dayStartWork;
        this.daysWork = daysWork;
        this.salaryInDays = salaryInDays;
        this.bonus = bonus;
        this.fine = fine;
    }

    public EmployeeFullTime(String id, String name, int age, String gender, String email, String nationality, LocalDate dayStartWork, int daysWork, int salaryInDays, double bonus, double fine) {
        super(id, name, age, gender, email, nationality);
        this.dayStartWork = dayStartWork;
        this.daysWork = daysWork;
        this.salaryInDays = salaryInDays;
        this.bonus = bonus;
        this.fine = fine;
    }

    public LocalDate getDayStartWork() {
        return dayStartWork;
    }

    public void setDayStartWork(LocalDate dayStartWork) {
        this.dayStartWork = dayStartWork;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
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
        return 0;
    }
    @Override
    public double getSalaryAfterInsurance() {
        if (getSalaryAfterIncrease() > 60000000) {
            return getSalaryAfterIncrease() * 0.9;
        }else if (getSalaryAfterIncrease() < 10000000){
            return getSalaryAfterIncrease();
        }else {
            return getSalaryAfterIncrease() * 0.95;
        }
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
}
