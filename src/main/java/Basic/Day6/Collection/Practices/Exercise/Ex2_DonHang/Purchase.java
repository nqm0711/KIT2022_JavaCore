/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic.Day6.Collection.Practices.Exercise.Ex2_DonHang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Purchase implements Comparable<Purchase>{
    private Integer IdPurchase;
    private Date purDate;
    private String SupplierID;

    public Purchase(Integer idPurchase, Date purDate, String supplierID) {
        IdPurchase = idPurchase;
        this.purDate = purDate;
        SupplierID = supplierID;
    }

    public Integer getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        IdPurchase = idPurchase;
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }

    @Override
    public String toString(){
        DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        return "Purchase: "+
                "IdPurchase= "+IdPurchase+'\''+
                ",purDate= "+dateFormat.format(purDate)+
                ",SupplierID= "+SupplierID+' ';
    }
    @Override
    public int compareTo(Purchase another){
        return 0;
    }
}
