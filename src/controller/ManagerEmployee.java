package controller;

import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ManagerEmployee {
    public static List<Employee> listEmployee = new ArrayList<>();
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
    }
    public static void deleteByIndex(int index) {
        listEmployee.remove(index);
    }
}
