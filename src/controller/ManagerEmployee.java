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
    public static void deleteByIndex(String id) {
        removeById(id);
    }

    private static void removeById(String id) {
        for (int i =0 ;i < listEmployee.size();) {
            if (listEmployee.get(i).getId().equals(id))
                listEmployee.remove(listEmployee.get(i));
            break;
        }
    }

    public static void editByIndex (int index,Employee employee) {
        listEmployee.set(index,employee);
    }

}
