package Models;

public class FullTime extends NhanVien {
    private int heSo;


    public FullTime(int id, String name, int age, String gender, int phone, String address, int heSo, boolean status) {
        super(id, name, age, gender, phone, address, status);
        this.heSo = heSo;
    }


    @Override
    public int getSalary() {
        return heSo * 30 * 600;
    }

    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }

    @Override
    public String toString() {
        return "FullTime " + super.toString() + "," +
                " heSo=" + heSo + " ]";
    }
}
