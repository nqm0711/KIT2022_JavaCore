/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic.Day6.Collection.Practices.Exercise.Ex2_DonHang;

/**
 *
 * @author Kien-PC
 */
public class Supplier implements Comparable<Supplier>{
    String IdSup;
    String Name;
    String Address;
    String Tel;

    public Supplier(String idSup, String name, String address, String tel) {
        IdSup = idSup;
        Name = name;
        Address = address;
        Tel = tel;
    }

    public String getIdSup() {
        return IdSup;
    }

    public void setIdSup(String idSup) {
        IdSup = idSup;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    @Override
    public String toString(){
        return "Supplier:"+
                ",IdSup= "+IdSup+'\''+
                ",Name= "+Name+'\''+
                ",Address= "+Address+
                ",Tel= "+Tel+
                ' ';
    }
    
    @Override
    public int compareTo(Supplier another){
        return 0;
    }
}
