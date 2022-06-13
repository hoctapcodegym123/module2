package Manager;

import Models.Account;
import Models.FullTime;
import Models.NhanVien;
import Models.PartTime;
import Validate.ValidateNhanVien;
import io.ReaderAndWriterNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerNhanVien {
    ArrayList<NhanVien> nhanViens = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    ValidateNhanVien validateNhanVien = new ValidateNhanVien();

    ReaderAndWriterNhanVien<NhanVien> readerAndWriterNhanVien = new ReaderAndWriterNhanVien();
    ReaderAndWriterNhanVien<Account> readerAndWriterAccount = new ReaderAndWriterNhanVien();

    ArrayList<Account> accounts = readerAndWriterAccount.reader("C:\\Users\\Admin\\IdeaProjects\\Module2\\src\\Data\\Account.txt");


    {
        nhanViens  = readerAndWriterNhanVien.reader(  "C:\\Users\\Admin\\IdeaProjects\\Module2\\src\\Data\\NhanVien.txt");
    }
    public void menuUser() {
        System.out.println("Chào mừng " + ManagerAccount.account.getUserName());
        System.out.println("1. Tìm kiếm nhân viên theo tên ");
        System.out.println("2. Show nhân viên");
        System.out.println("3.Đăng xuất");
        int choice = validateNhanVien.choiceUser("option");
        switch (choice) {
            case 1:
                findNVByName();
                break;
            case 2:
                showNV();
                break;
            case 3:
                logOutNV();
                break;
        }
    }

    public void menuAdmin() {
        System.out.println("Chào mừng " + ManagerAccount.account.getUserName());
        System.out.println("------Menu------");
        System.out.println("1. Thêm nhân viên ");
        System.out.println("2. Tìm kiếm nhân viên theo tên");
        System.out.println("3. Kiểm tra trạng thái nhân viên");
        System.out.println("4. Sửa thông tin nhân viên");
        System.out.println("5. Thay đổi trạng thái nhân viên");
        System.out.println("6. Xóa nhân viên");
        System.out.println("7. Thông tin tài khoản");
        System.out.println("8. Tính lương nhân viên");
        System.out.println("9. Read on file");
        System.out.println("10. Write on file");
        System.out.println("11. Show nhân viên");
        System.out.println("12. Đăng xuất");
        System.out.println("13. Exit");
        int choice = validateNhanVien.choiceAdmin("option");
        switch (choice) {
            case 1:
                addNV();
                break;
            case 2:
                findNVByName();
                break;
            case 3:
                checkStatusNV();
                break;
            case 4:
                editNV();
                break;
            case 5:
                changeStatusNV();
                break;
            case 6:
                deleteNV();
                break;
            case 7:
                showAccountNV();
                break;
            case 8:
                showSalary();
                break;
            case 9:
                readfileNV();
                break;
            case 10:
                writefileNV();
                break;
            case 11:
                showNV();
                break;
            case 12:
                logOutNV();
                break;
            case 13:
                quitNV();
                break;
        }
    }

    //Case 1
    public void addNV() {
        System.out.println("1. Thêm nhân viên full time");
        System.out.println("2. Thêm nhân viên part time");
        int choiceKind = Integer.parseInt(scanner.nextLine());
        switch (choiceKind) {
            case 1:
                int id1 = validateNhanVien.validateIdNV(nhanViens);
                NhanVien nhanVienFullTime = createNhanVien(id1,true);
                nhanViens.add(nhanVienFullTime);
                readerAndWriterNhanVien.Write(nhanViens, "C:\\Users\\Admin\\IdeaProjects\\Module2\\src\\Data\\NhanVien.txt");
                break;
            case 2:
                int id2 = validateNhanVien.validateIdNV(nhanViens);
                NhanVien nhanVienPartTime = createNhanVien(id2,false);
                nhanViens.add(nhanVienPartTime);
                readerAndWriterNhanVien.Write(nhanViens, "C:\\Users\\Admin\\IdeaProjects\\Module2\\src\\Data\\NhanVien.txt");
                break;
        }
        System.out.println("Thêm thành công");
    }
    public NhanVien createNhanVien(int id, boolean isFullTime) {


        String name = validateNhanVien.validateString("họ tên");
        int age = validateNhanVien.validateAge();
        String gender = validateNhanVien.validateString("giới tính");
        int phone = validateNhanVien.validatePhone();
        String address = validateNhanVien.validateString("địa chỉ");
        if (isFullTime) {
            System.out.println("Nhập số ngày làm full");
            int heSo = Integer.parseInt(scanner.nextLine());
            return new FullTime(id, name, age, gender, phone, address,heSo, true);
        } else {
            System.out.println("Nhập số buổi làm parttime");
            int number = Integer.parseInt(scanner.nextLine());
            return new PartTime(id, name, age, gender, phone, address,number,true);
        }
    }

    //Case 2
    public void findNVByName(){
        String name = validateNhanVien.validateString("tên cần tìm kiếm");
        for (NhanVien nv: nhanViens) {
            if(nv.getName().equals(name)){
                System.out.println(nv);
                break;
            }
        }
        System.out.println("Không có nhân viên cần tìm");
    }

    //Case 3
    public void checkStatusNV(){
        System.out.println("Nhân viên đang làm :");
        for (NhanVien nv:nhanViens) {
            if(nv.isStatus()){
                System.out.println(nv.getName());
            }
        }
        System.out.println("Nhân viên đang nghỉ :");
        for (NhanVien nv:nhanViens) {
            if (!nv.isStatus()){
                System.out.println(nv.getName());
            }
        }
    }

    //Case 4
    public void editNV() {
        System.out.println("Nhập id của nhân viên muốn sửa");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getIdNV() == id) {
                nhanViens.set(i, createNhanVien(nhanViens.get(i).getIdNV(),nhanViens.get(i) instanceof FullTime));
            }
        }
    }

    //Case 5
    public void changeStatusNV(){
        int id = validateNhanVien.checkInt(" id nhân viên cần sửa trạng thái");
        for (int i = 0; i < nhanViens.size(); i++) {
            if(nhanViens.get(i).getIdNV()==id){
                if (nhanViens.get(i).isStatus()) {
                    nhanViens.get(i).setStatus(false);
                } else nhanViens.get(i).setStatus(true);
            }
        }
    }

    //Case 6
    public void deleteNV() {
        int id = validateNhanVien.validateDelNV();
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getIdNV() == id) {
                nhanViens.remove(nhanViens.get(i));
            }
        }
        System.out.println("Xoá thành công");
    }

    //Case 7
    public void showAccountNV(){
        for (Account acc: accounts) {
            System.out.println(acc);
        }
    }

    //Case8

    public void showSalary(){
        System.out.println("1. FullTime");
        System.out.println("2. PartTime");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof FullTime) {
                        System.out.println(nv.getName() + " = " + nv.getSalary()+" VNĐ");
                    }
                }
                break;
            case 2:
                for (NhanVien nv : nhanViens) {
                    if (nv instanceof PartTime) {
                        System.out.println(nv.getName() + " = " + nv.getSalary());
                    }
                }
                break;
        }
    }

    //Case 9
    public void readfileNV() {
        nhanViens = readerAndWriterNhanVien.reader("C:\\Users\\Admin\\IdeaProjects\\Module2\\src\\Data\\NhanVien.txt");
        System.out.println("đọc thành công");
    }

    //Case 10
    public void writefileNV() {
        readerAndWriterNhanVien.Write(nhanViens, "C:\\Users\\Admin\\IdeaProjects\\Module2\\src\\Data\\NhanVien.txt");
        System.out.println("ghi thành công");
    }

    //Case 11
    public void showNV() {
        for (NhanVien nv: nhanViens) {
            System.out.println(nv);
        }
    }

    //Case 12
    public void logOutNV() {
        ManagerAccount.account = null;
    }

    //Case 13
    public void quitNV() {
        System.exit(0);
    }


}
