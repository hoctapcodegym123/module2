package Manager;

import Validate.ValidateNhanVien;
import io.ReaderAndWriterNhanVien;
import Models.Account;

import java.util.ArrayList;
import java.util.Scanner;


public class ManagerAccount {
    ReaderAndWriterNhanVien<Account> readerAndWriterNhanVien = new ReaderAndWriterNhanVien<>();

    Scanner scanner = new Scanner(System.in);
    public static Account account;
    public  static ArrayList<Account> accounts = new ArrayList<>();

    ValidateNhanVien validateNhanVien = new ValidateNhanVien();

    {
        accounts = readerAndWriterNhanVien.reader("C:\\Users\\Admin\\IdeaProjects\\Module2\\src\\Data\\Account.txt");
        if (accounts.size() == 0) {
            accounts.add(new Account("admin", "admin", "admin"));
        }
    }

    public void menuLogin() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        int choice1 = validateNhanVien.choiceLogin("option Login");
        switch (choice1) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
        }
    }

    //Case 1
    public boolean login() {
        System.out.println("Nhập Tài Khoản :");
        String user = scanner.nextLine();
        System.out.println("Nhập Mật Khẩu :");
        String pass = scanner.nextLine();

        for (Account acc : accounts) {
            if (acc.getUserName().equals(user) && acc.getPass().equals(pass)) {
                ManagerAccount.account = acc;
                return true;
            }
        }
        System.out.println("Sai tài khoản hoặc mật khẩu");
        return false;
    }

    //Case 2
    public void register() {
        String user = null;
        while (true) {
            System.out.println("Nhập Tài Khoản :");
            user = scanner.nextLine();
            if (checkUserName(user)) {
                break;
            }
        }
        System.out.println("Nhập Mật Khẩu :");
        String pass = scanner.nextLine();

        accounts.add(new Account(user,pass,"user"));

        readerAndWriterNhanVien.Write(accounts,"C:\\Users\\Admin\\IdeaProjects\\Module2\\src\\Data\\Account.txt");
    }

    public boolean checkUserName(String userName) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(userName)) {
                ManagerAccount.account = acc;
                return false;
            }
        }
        return true;
    }
}
