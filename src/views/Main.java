package views;

import controller.ManagerEmployee;
import controller.RegexInformationInput;
import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static List<Employee> listEmployee = ManagerEmployee.listEmployee;

    public static void main(String[] args) {
        int choice = -1;
        do {
            System.out.println("MENU");
            System.out.println("0. Exit");
            System.out.println("1. Thêm nhân viên ");
            System.out.println("2. Xóa nhân viên ");
            System.out.println("3. Sửa nhân viên ");
            System.out.println("4. In ra danh sách nhân viên");
            System.out.println("5. Tổng lương nhân viên");
            System.out.println("6. Tổng lương nhân viên fulltime");
            System.out.println("7. Tổng lương nhân viên parttime");
            System.out.println("8. Số tiền đã tăng cho nhân viên lâu năm");
            System.out.println("9. Số tiền bảo hiểm nhân viên đax đóng");
            System.out.println("Nhập lựa chọn của bạn");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    Employee employee = newEmployee();
                    ManagerEmployee.addEmployee(employee);
                    System.out.println(ManagerEmployee.listEmployee);
                    break;
                case 2:
                    String id = removeEmployee();
                    ManagerEmployee.deleteById(id);
                    System.out.println(ManagerEmployee.listEmployee);
                    break;
                case 3:
                    editEmployee();
                case 4:
                    System.out.println(ManagerEmployee.listEmployee);

            }
        } while (choice != -1);
    }

    public static Employee newEmployee() {
        System.out.println("Nhập id");
        String id = RegexInformationInput.getRegexId();
        System.out.println("Nhập name");
        String name = RegexInformationInput.getRegexName();
        System.out.println("Nhập age");
        int age = Integer.parseInt(RegexInformationInput.getRegexAge());
        Scanner scanner0 = new Scanner(System.in);
        System.out.println("Nhập giới tính");
        String gender = scanner0.nextLine();
        System.out.println("Nhập email");
        String email = RegexInformationInput.getRegexEmail();
        System.out.println("Nhập nationally");
        String nationally = RegexInformationInput.getRegexNation();
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
                int daysWork = Integer.parseInt(RegexInformationInput.getRegexNum());
                System.out.println("Lương 1 ngay ");
                int salaryInADay = Integer.parseInt(RegexInformationInput.getRegexNum());
                System.out.println("Số giờ tăng ca");
                int overTime = Integer.parseInt(RegexInformationInput.getRegexNum());
                System.out.println("Số ngày đi trễ ");
                int late = Integer.parseInt(RegexInformationInput.getRegexNum());
                EmployeeFullTime employeeFullTime = new EmployeeFullTime(id, name, age, gender, email, nationally, LocalDate.parse(timeStartWork, formatter), daysWork, salaryInADay, overTime, late);
                return employeeFullTime;
            case "P":
                System.out.println("Nhập số giờ làm việc");
                int hourWork = Integer.parseInt(RegexInformationInput.getRegexNum());
                System.out.println("Nhap so tien trong 1 giờ");
                int salaryInAHour = Integer.parseInt(RegexInformationInput.getRegexNum());
                EmployeePartTime employeePartTime = new EmployeePartTime(id, name, age, gender, email, nationally, hourWork, salaryInAHour);
                return employeePartTime;
            default:
                return null;
        }
    }

    public static String removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id mà bạn muốn xóa");
        String id = scanner.nextLine();
        return id;
    }

    public static void editEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập index mà bạn muốn sua");
        int index = scanner.nextInt();
        if (listEmployee.get(index) instanceof EmployeePartTime) {
            System.out.println("Nhập id");
            String id = RegexInformationInput.getRegexId();
            System.out.println("Nhập name");
            String name = RegexInformationInput.getRegexName();
            System.out.println("Nhập age");
            int age = Integer.parseInt(RegexInformationInput.getRegexAge());
            System.out.println("Nhập giới tính");
            String gender = RegexInformationInput.getRegexGender();
            System.out.println("Nhập email");
            String email = RegexInformationInput.getRegexEmail();
            System.out.println("Nhập nationally");
            String nationally = RegexInformationInput.getRegexNation();
            System.out.println("Nhập số giờ làm việc");
            int hourWork = Integer.parseInt(RegexInformationInput.getRegexAge());
            System.out.println("Nhap so tien trong 1 giờ");
            int salaryInAHour = Integer.parseInt(RegexInformationInput.getRegexAge());
            EmployeePartTime employeePartTime = new EmployeePartTime(id, name, age, gender, email, nationally, hourWork, salaryInAHour);
            ManagerEmployee.editByIndex(index, employeePartTime);
        } else {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Nhập id");
            String id = RegexInformationInput.getRegexId();
            System.out.println("Nhập name");
            String name = RegexInformationInput.getRegexName();
            System.out.println("Nhập age");
            int age = Integer.parseInt(RegexInformationInput.getRegexAge());
            System.out.println("Nhập giới tính");
            String gender = RegexInformationInput.getRegexGender();
            System.out.println("Nhập email");
            String email = RegexInformationInput.getRegexEmail();
            System.out.println("Nhập nationally");
            String nationally = RegexInformationInput.getRegexNation();
            System.out.println("Mời bạn nhap thời gian bắt đầu làm việc yyyy-MM-dd ");
            String timeStartWork = scanner1.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Số ngày làm việc");
            int daysWork = Integer.parseInt(RegexInformationInput.getRegexAge());
            System.out.println("Lương 1 ngay ");
            int salaryInADay = Integer.parseInt(RegexInformationInput.getRegexAge());
            System.out.println("Số giờ tăng ca");
            int overTime = Integer.parseInt(RegexInformationInput.getRegexAge());
            System.out.println("Số ngày đi trễ ");
            int late = Integer.parseInt(RegexInformationInput.getRegexAge());
            EmployeeFullTime employeeFullTime = new EmployeeFullTime(id, name, age, gender, email, nationally, LocalDate.parse(timeStartWork, formatter), daysWork, salaryInADay, overTime, late);
            ManagerEmployee.editByIndex(index, employeeFullTime);
        }
    }
}