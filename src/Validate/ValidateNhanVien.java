package Validate;

import Models.NhanVien;


import java.util.List;
import java.util.Scanner;

public class ValidateNhanVien {
    Scanner scanner = new Scanner(System.in);

    public int checkInt(String name) {
        while (true) {
            try {
                System.out.println("Nhập " + name);
                int result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại.");
                checkInt(name);

            }
        }
    }

    public int choiceAdmin(String option) {
        while (true) {
            try {
                System.out.println("Nhập " + option);
                int button = Integer.parseInt(scanner.nextLine());
                if (button > 0 && button < 14) {
                    return button;
                } else {
                    System.err.println("Vui lòng nhập lệnh hợp lệ");
                    return choiceAdmin(option);

                }
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại.");
                checkInt(option);
            }
        }
    }

    public int choiceUser(String option) {
        while (true) {
            try {
                System.out.println("Nhập " + option);
                int button = Integer.parseInt(scanner.nextLine());
                if (button > 0 && button < 4) {
                    return button;
                } else {
                    System.err.println("Vui lòng nhập lệnh hợp lệ");
                    return choiceAdmin(option);

                }
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại.");
                checkInt(option);
            }
        }
    }
    public int choiceLogin(String option) {
        while (true) {
            try {
                System.out.println("Nhập " + option);
                int button = Integer.parseInt(scanner.nextLine());
                if (button > 0 && button < 3) {
                    return button;
                } else {
                    System.err.println("Vui lòng nhập lệnh hợp lệ");
                    return choiceAdmin(option);

                }
            } catch (Exception e) {
                System.out.println("Nhập sai cú pháp , vui lòng nhập lại.");
                checkInt(option);
            }
        }
    }



    public int validateIdNV(List<NhanVien> nhanViens) {
        while (true) {
            try {
                System.out.println("Nhập id");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, nhanViens) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai kiểu, vui lòng nhập id bằng số.");
            }
        }
    }

    public int getIndexId(int id, List<NhanVien> nhanViens) {
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getIdNV() == id) {
                return i;
            }
        }
        return -1;
    }

    public String validateString(String name) {
        while (true) {
            System.out.println("Hãy nhập " + name);
            String str = scanner.nextLine();
            if (str.equals("")) {
                System.err.println("Không được để trống.");
                continue;
            } else {
                return str;
            }
        }
    }

    public int validateAge() {
        while (true) {
            try {
                System.out.println("Hãy nhập tuổi");
                int age = Integer.parseInt(scanner.nextLine());
                return age;
            } catch (Exception e) {
                System.err.println("Nhập sai kiểu, vui lòng nhập tuổi bằng số.");
            }
        }
    }

    public int validatePhone() {
        while (true) {
            try {
                System.out.println("Hãy nhập số điện thoại");
                int phone = Integer.parseInt(scanner.nextLine());
                return phone;
            } catch (Exception e) {
                System.err.println("Nhập sai kiểu, vui lòng nhập sđt bằng số");
            }
        }
    }

    public int validateDelNV() {
        while (true) {
            try {
                System.out.println("Hãy nhập id");
                int id = Integer.parseInt(scanner.nextLine());
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai cú pháp");
            }
        }
    }
}
