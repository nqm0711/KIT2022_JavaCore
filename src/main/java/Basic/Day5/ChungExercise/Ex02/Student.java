package Basic.Day5.ChungExercise.Ex02;

import java.io.Serializable;

public class Student implements Serializable {
    private String hoten;
    private String quequan;
    private int namsinh;
    private float diemTB;

    public Student() {
    }

    public Student(String hoten, String quequan, int namsinh, float diemTB) {
        this.hoten = hoten;
        this.quequan = quequan;
        this.namsinh = namsinh;
        this.diemTB = diemTB;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

}
