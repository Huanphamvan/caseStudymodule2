package validator;

import java.util.Scanner;

public class ValidatorStaff {


    public static String inputAccount() {
        Scanner scanner = new Scanner(System.in);
        String regex = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
        String account;
        do {
            System.out.println("Nhập Tên Tài Khoản, Tài Khoản Phải Có Ít Nhất là 8 Ký Tự,có cấu trúc là :" +
                    " chữ cái+ số + @ + dấu chấm + chữ cái");
            account = scanner.nextLine();
            if (account.matches(regex)) {
                break;
            }
        } while (true);
        return account;
    }

    public static String inputPassWord() {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[a-zA-Z0-9!@#$%^&*()_+-={}|,.<>/?]{8,}$";
        String password;
        do {
            System.out.println("Nhập Mật Khẩu, lưu ý mật khẩu phải có ít nhất là 8 ký tự : ");
            password = scanner.nextLine();
            if (password.matches(regex)) {
                break;
            }
        } while (true);
        return password;
    }


    public static int inputChoice() {
        Scanner input = new Scanner(System.in);
        String choiceRegex = "[0-9]";
        String choice;
        do {
            System.out.println(" Xin mời bạn nhập sự lựa chọn");
            choice = input.nextLine();
            if (choice.matches(choiceRegex)) {
                break;
            } else {
                System.out.println("bạn chỉ được phép chọn số từ 0 đến 9");
            }
        } while (true);
        return Integer.parseInt(choice);
    }

    public static int inputId() {
        Scanner input = new Scanner(System.in);
        String choiceRegex = "^\\d{2,}$";
        String choice;
        do {
            System.out.println("Xin mời bạn nhập vào id,id phải là số và có từ 2 ký tự trở lên : ");
            choice = input.nextLine();
            if (choice.matches(choiceRegex)) {
                break;
            } else {
                System.out.println("xin nhắc lại id phải là số, và có từ 2 ký tự trở lên");
            }
        } while (true);
        return Integer.parseInt(choice);
    }


}
