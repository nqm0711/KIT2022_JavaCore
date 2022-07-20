/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic.Day6.Collection.Practices.Exercise.Ex2_DonHang;

/**
 *
 * @author Kien-PC
 */
public class OrderDetail implements Comparable<OrderDetail>{
    private Integer IdOrder;
    private Integer IdDetail;
    private Integer IdItem;
    private Integer Amount;
    private Float Price;

    public OrderDetail(Integer idOrder, Integer idDetail, Integer idItem, Integer amount, Float price) {

        IdOrder = idOrder;
        IdDetail = idDetail;
        IdItem = idItem;
        Amount = amount;
        Price = price;
    }

    public Integer getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(Integer idOrder) {
        IdOrder = idOrder;
    }

    public Integer getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(Integer idDetail) {
        IdDetail = idDetail;
    }

    public Integer getIdItem() {
        return IdItem;
    }

    public void setIdItem(Integer idItem) {
        IdItem = idItem;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    @Override
    public String toString(){
        return "OrderDetail:{"+
                "IdOrder= "+IdOrder+'\''+
                ",IdDetail= "+IdDetail+'\''+
                ",IdItem= "+IdItem+
                ",IdAmount= "+Amount+
                ",Price= "+Price+'}';
    }
    
    @Override
    public int compareTo(OrderDetail another){
        return 0;
    }
}
