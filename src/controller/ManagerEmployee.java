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
        ManagerEmployee.listEmployee = listEmployee;
    }
    public static void addEmployee(Employee employee) {
      listEmployee.add(employee);
      ReadWriteFile.getInstance().writeFile(listEmployee);
    }

    public static void removeById(String id) {
        for (int i =0 ;i < listEmployee.size();) {
            if (listEmployee.get(i).getId().equals(id))
                listEmployee.remove(listEmployee.get(i));
            break;
        }
    }

    public static void editByIndex (int index,Employee employee) {
        listEmployee.set(index,employee);
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

}
