package views;

import controller.ManagerEmployee;
import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Employee> listEmployees = ManagerEmployee.listEmployee;

    public static void main(String[] args) {
        Employee employee = newEmployee();
        ManagerEmployee.addEmployee(employee);
        System.out.println(ManagerEmployee.listEmployee);
    }
    public static Employee newEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id");
        String id = scanner.nextLine();
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập age");
        int age = scanner.nextInt();
        Scanner scanner0 = new Scanner(System.in);
        System.out.println("Nhập giới tính");
        String gender = scanner0.nextLine();
        System.out.println("Nhập email");
        String email = scanner0.nextLine();
        System.out.println("Nhập nationally");
        String nationally = scanner0.nextLine();
        System.out.println("Bạn mốn thêm nhân viên fulltime or parttime");
        System.out.println("fulltime vui lòng nhập 'F' or parttime vui lòng nhập 'P'");
        String type = scanner0.nextLine();
        switch (type) {
            case "F":

                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Mời bạn nhap thời gian bắt đầu làm việc yyyy-MM-dd ");
                String timeStartWork = scanner1.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                System.out.println("Số ngày làm việc");
                int daysWork = scanner1.nextInt();
                System.out.println("Lương 1 ngay ");
                int salaryInADay = scanner1.nextInt();
                System.out.println("Số giờ tăng ca");
                int overTime = scanner1.nextInt();
                System.out.println("Số ngày đi trễ ");
                int late = scanner1.nextInt();
                EmployeeFullTime employeeFullTime = new EmployeeFullTime(id,name,age,gender,email,nationally, LocalDate.parse(timeStartWork,formatter),daysWork,salaryInADay,overTime,late);
                return employeeFullTime;
            case "P" :
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Nhập số giờ làm việc");
                int hourWork = scanner2.nextInt();
                System.out.println("Nhap so tien trong 1 giờ");
                int salaryInAHour = scanner2.nextInt();
                EmployeePartTime employeePartTime = new EmployeePartTime(id,name,age,gender,email,nationally,hourWork,salaryInAHour);
                return employeePartTime;
            default:
                return null;
        }
    }
}