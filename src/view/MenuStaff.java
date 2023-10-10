package view;

import account.Account;
import account.AccountManager;
import manager.StaffManager;
import model.Staff;
import validator.ValidatorStaff;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuStaff {
    int count = 0;
    AccountManager accountManager = new AccountManager();
    StaffManager staffManager = new StaffManager();
    Scanner scanner = new Scanner(System.in);
    public void show() {
        int choice;
        do {
            System.out.println( "===Menu===\n1.Đăng Kí Tài Khoản\n2.Đăng Nhập\n3.Hiển Thị Tài Khoản \n0.Thoát");
            choice = ValidatorStaff.inputChoice();
            switch (choice) {
                case 1:
                    showRegister();
                    break;
                case 2:
                    loginAccount();
                    break;
                case 3:
                    findAll();
                    break;

            }
        } while (choice != 0);
    }
    public void showRegister() {
        System.out.println( "Đăng Kí Tài Khoản");
        String account1 = ValidatorStaff.inputAccount();
        String pass = ValidatorStaff.inputPassWord();
        Account account = new Account(account1, pass);
        accountManager.register(account);
        System.out.println( "Đăng Kí Thành Công");
    }
    public boolean login() {
        String user = ValidatorStaff.inputAccount();
        String pass = ValidatorStaff.inputPassWord();
        for (Account account : accountManager.showAll()) {
            if (user.equals(account.getUsername()) && pass.equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public void loginAccount() {
        boolean login = login();
        int choice;
        if (login == true) {
            System.out.println( "Đăng Nhập Thành Công");
            do {
                count = 0;
                System.out.println( "===Menu===\n1.Thêm Nhân Viên\n2.Tìm  Nhân Viên Theo Tên \n3.Kiểm Tra Trạng Thái Nhân Viên" +
                        "\n4.Sửa Thông Tin Nhân Viên\n5.Thay Đổi Trạng Thái Nhân Viên\n6.Xóa Nhân Viên\n7.Tính Lương Nhân Viên\n8.Hiển Thị Tất Cả\n0.Đăng Xuất");
                System.out.println( "Nhập lựa chọn của bạn");
                choice = ValidatorStaff.inputChoice();
                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        searchStatus();
                        break;
                    case 4:
                        update();
                        break;
                    case 5:
                        setStatus();
                        break;
                    case 6:
                        remove();
                        break;
                    case 7:
                        searchSalary();
                        break;
                    case 8:
                        showAllStaff();
                        break;
                }
            } while (choice != 0);

        } else {
            count++;
            System.out.println("Nhập Sai Tài Khoản Hoặc Mật Khẩu");
            changePassword();
        }
    }
    public void findAll() {
        System.out.println("Danh sách các tài khoản là : ");
        List<Account>list = accountManager.showAll();
        for (Account account: list) {
            System.out.println(account);
        }
    }
    public void changePassword() {
        if (count == 3) {
            int choice;
            System.out.println( "Nhập 1 Để Đổi Mật Khẩu\n Nhập 2 Để Đăng Nhập ");
            choice = ValidatorStaff.inputChoice();
            switch (choice) {
                case 1:
                    passWord();
                    break;
                case 2:
                    loginAccount();
                    break;
            }

        }
    }
    public void passWord() {
        System.out.println("Nhập Tên Tài Khoản Bạn Muốn Thay Đổi");
        String email = ValidatorStaff.inputAccount();
        System.out.println( "Nhap Mat Khau Ban Muon Thay Doi");
        String passWord = ValidatorStaff.inputPassWord();
        Account account = new Account(email, passWord);
        accountManager.changePassWord(email, account);
    }
    public boolean status() {
        do {
            try {
                int status = Integer.parseInt(scanner.nextLine());
                if (status == 1) {
                    return true;
                }
                return false;
            } catch (NumberFormatException e) {
                scanner.nextLine();
                System.out.println( "Yêu Cầu Bạn Nhập Đúng");
            }
        } while (true);

    }

    public String staffType() {
        do {
            try {
                System.out.println("Xin mời bạn nhập loại hình nhân viên : \n1. Nhân Viên FullTime\n2. Nhân Viên PartTime");
                int staffType = scanner.nextInt();
                if (staffType == 1) {
                    return "FullTime";
                } else if (staffType == 2) {
                    return "PartTime";
                }
                return "Nhân Viên Thử Việc";
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Yêu cầu Bạn Nhập Lại");
            }
        } while (true);


    }
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Nhập ID Nhân Viên");
        int id = ValidatorStaff.inputId();
        System.out.println("Nhập Tên Nhân Viên");
        String name = scanner.nextLine();
        System.out.println("Nhập Giới Tính  Nhân Viên");
        String gender = scanner.nextLine();
        System.out.println( "Nhập Trạng Thái");
        boolean status = status();
        System.out.println( "Nhập Kiểu Nhân Viên");
        String employeeType = staffType();
        Staff staff = new Staff(id, name,gender, status, employeeType);
        staffManager.add(staff);
        System.out.println( "Thêm Nhân Viên Thành Công");
    }
    public void search() {
        System.out.println( "Nhập Tên Mà Bạn Muốn Tìm");
        String name = scanner.nextLine();
        System.out.println(staffManager.seachName(name));
    }
    public void searchStatus() {

        System.out.println( "Nhập Tên Bạn Muốn Xác Định Trạng Thái: ");
        String name = scanner.nextLine();
        System.out.println(staffManager.searchStatus(name));
    }
    public void update() {
        System.out.println("Nhập ID Bạn Muốn Sửa");
        int idEdit = ValidatorStaff.inputId();
        System.out.println("Nhâp Tên Nhân Viên");
        String name = scanner.nextLine();
        System.out.println("Nhập Giới Tính  Nhân Viên");
        String gender = scanner.nextLine();
        System.out.println("Nhập Trạng Thai");
        boolean status = status();
        System.out.println( "Nhập Kiểu Nhân Viên");
        String employeeType = staffType();
        Staff staff1 = new Staff(idEdit, name,gender, status, employeeType);
        staffManager.edit(idEdit, staff1);
    }
    public void remove() {
        System.out.println( "Nhập ID Bạn Muốn Xóa");
        int id = ValidatorStaff.inputId();
        staffManager.delete(id);
    }
    public void searchSalary() {
        do {
            try {
                System.out.println( "Nhập ID Muốn Tìm");
                int id = ValidatorStaff.inputId();
                String salary = staffManager.salary(id);
                if (salary.equals("FullTime")) {
                    System.out.println( "Lương Nhân Viên Này Được Mười Triệu Đồng");
                } else {
                    System.out.println("Nhập Số Giờ Làm Trong Tháng");
                    int house = scanner.nextInt();
                    System.out.println("Lương Nhân Viên Này Là " + house * 20000);
                }
                break;
            } catch (NullPointerException e) {
                System.out.println( "Nhap lai");
            }
        } while (true);
    }
    public void showAllStaff() {
        for(Staff staff : staffManager.findAll()) System.out.println(staff);
    }
    public void setStatus() {
        System.out.println( "Nhập id bạn Sửa");
        int idEdit = ValidatorStaff.inputId();
        System.out.println( "Nhập Trạng Thái");
        boolean status = status();
        staffManager.status(idEdit, status);
    }





}
