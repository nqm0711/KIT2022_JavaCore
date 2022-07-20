/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic.Day6.Collection.Practices.Exercise.Ex2_DonHang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Order implements Comparable<Order>{
    protected static Integer IdOrder;
    private Date OrdDate;
    private String CustomerID;

    public Order(Integer idOrder, Date ordDate, String customerID) {
        IdOrder = idOrder;
        OrdDate = ordDate;
        CustomerID = customerID;
    }

    public static Integer getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(Integer idOrder) {
        IdOrder = idOrder;
    }

    public Date getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(Date ordDate) {
        OrdDate = ordDate;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    @Override
    public String toString(){
        DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
        return "Order: "+
                "IdOrder= "+IdOrder+
                ",OrdDate= "+dateFormat.format(OrdDate)+
                ",CustomerID= "+CustomerID+' ';
    }
    @Override
    public int compareTo(Order another){
        return this.getIdOrder().compareTo(another.getIdOrder());
    }
}
