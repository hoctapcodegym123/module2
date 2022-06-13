package Manager;

public class Main {
    public static void main(String[] args) {
        ManagerNhanVien managerNhanVien = new ManagerNhanVien();
        ManagerAccount managerAccount = new ManagerAccount();
        while (true) {
            if (ManagerAccount.account == null) {
                managerAccount.menuLogin();
            } else {
               if (ManagerAccount.account.getRole().equals("admin")){
                   managerNhanVien.menuAdmin();
               }else {
                   managerNhanVien.menuUser();
               }
            }
        }
    }
}
