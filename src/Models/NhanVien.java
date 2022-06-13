package Models;


import java.io.Serializable;

public class NhanVien implements Serializable {
    private int idNV;
    private String name;
    private int age;
    private String gender;
    private int phone;
    private String address;
    private boolean status;
    private int heSo;

    private int number;


    public NhanVien(int id, String name, int age, String gender, int phone, String address, boolean status) {
        this.idNV = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public int getSalary() {
        return 0;
    }


    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NhanVien " + "[ ID nhân viên =" + idNV + ", name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + ", phone=" + phone + ", address='" + address + '\'' + ", status=" + status;
    }

}
