package Basic.Day5.JavaIO.Ex2;

import java.io.Serializable;

public class Student implements Serializable {
    private String hoTen;
    private String queQuan;
    private int namSinh;
    private float diemTB;

    public Student() {
    }

    public Student(String hoten, String quequan, int namsinh, float diemTB) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.namSinh = namSinh;
        this.diemTB = diemTB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoten) {
        this.hoTen = hoTen;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String quequan) {
        this.queQuan = queQuan;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

}
