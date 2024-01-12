package controller;

import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;
import storage.ReadWriteFile;

import java.util.Collections;
import java.util.List;

public class ManagerEmployee {
    public static final int COUNT = 0;
    public static final int TOTAL = 0;
    public static List<Employee> listEmployee = ReadWriteFile.getInstance().readFile();
    public ManagerEmployee() {
    }

    public static List<Employee> getListEmployee() {
        return listEmployee;
    }

    public static void setListEmployee(List<Employee> listEmployee) {
        ReadWriteFile.getInstance().writeFile(listEmployee);
        ManagerEmployee.listEmployee = listEmployee;
    }
    public static void addEmployee(Employee employee) {
      listEmployee.add(employee);
      ReadWriteFile.getInstance().writeFile(listEmployee);
    }

    public static void removeById(String id) {
        for (Employee e : listEmployee) {
            if (e.getId().equals(id)) {
                listEmployee.remove(e);
                ReadWriteFile.getInstance().writeFile(listEmployee);
                return;
            }
        }
    }

    public static void editById (String id) {
        for (Employee e : listEmployee) {
            if (e.getId().equals(id)) {
                int choice = -1;

            }
        }
    }

    public static void editByIndex (int index,Employee employee) {
        listEmployee.set(index,employee);
        ReadWriteFile.getInstance().writeFile(listEmployee);
    }

    public static double totalSalaryReality() {
        int total = TOTAL;
        for (Employee e : listEmployee) {
            if (e instanceof EmployeeFullTime) {
                total += (int) ((EmployeeFullTime) e).getSalaryReality();
            }else {
                total += (int) e.getSalary();
            }
        }
        return total;
    }
    public static double totalSalaryPartTime() {
        int total = TOTAL;
        for (Employee e : listEmployee) {
            if(e instanceof EmployeeFullTime) {
                total += (int) ((EmployeeFullTime) e).getSalaryReality();
            }
        }
        return total;
    }
    public static double totalSalaryFullTime() {
        int total = TOTAL;
        for (Employee e : listEmployee) {
            if (e instanceof EmployeePartTime) {
                total += (int) e.getSalary();
            }
        }
        return total;
    }
    public static double averageSalary () {
        int total = TOTAL;
        int count = COUNT;
        for (Employee e : listEmployee) {
            if (e instanceof EmployeeFullTime) {
                total += (int) ((EmployeeFullTime) e).getSalaryReality();
                count ++;
            }else {
                total += (int) e.getSalary();
                count ++;
            }
        }
        return (double) total /count;
    }

    public static double initialSalary () {
        int total = TOTAL;
        for (Employee e : listEmployee) {
            total += (int) e.getSalary();
        }
        return total;
    }

    public static double differenceAmount() {
       return totalSalaryReality() - initialSalary();
    }
    public static void arrangeAge() {
        Collections.sort(listEmployee);
        for (Employee e : listEmployee) {
            System.out.println(e);
        }
    }
}
