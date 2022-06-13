package Models;

public class PartTime extends NhanVien {
    private int numberTime;


    public PartTime(int id, String name, int age, String gender, int phone, String address, int numberTime, boolean status) {
        super(id, name, age, gender, phone, address, status);
        this.numberTime = numberTime;
    }

    @Override
    public int getSalary() {
        return numberTime * 250;
    }


    @Override
    public String toString() {
        return "PartTime " + super.toString() + "," +
                " numberTime=" + numberTime + " ]";
    }
}
