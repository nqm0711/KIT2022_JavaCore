/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic.Day6.Collection.Practices.Exercise.Ex1_GuiTien;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NguoiGuiTien extends Object implements Comparable<NguoiGuiTien>{

    private String Ma;
    private String Hoten;
    private String Diachi;
    private Date Ngaysinh;

    private String Sodienthoai;

    public NguoiGuiTien(String Ma,String Hoten, String Diachi,String Sodienthoai,  Date Ngaysinh) {
        this.Hoten = Hoten;
        this.Diachi = Diachi;
        this.Ngaysinh = Ngaysinh;
        this.Ma = Ma;
        this.Sodienthoai = Sodienthoai;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "("+Hoten + " " + Diachi + " " + dateFormat.format(Ngaysinh)+")";
    }
    @Override
    public boolean equals(Object obj) {
        return ((NguoiGuiTien)obj).Ma.equalsIgnoreCase(this.Ma);
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        Ngaysinh = ngaysinh;
    }

    public String getSodienthoai() {
        return Sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        Sodienthoai = sodienthoai;
    }

    @Override
    public int compareTo(NguoiGuiTien obj) {
        return Ma.compareTo(obj.Ma);
    }
}
