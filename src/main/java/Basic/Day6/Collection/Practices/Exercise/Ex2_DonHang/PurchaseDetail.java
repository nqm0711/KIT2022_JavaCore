/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic.Day6.Collection.Practices.Exercise.Ex2_DonHang;

/**
 *
 * @author Kien-PC
 */
public class PurchaseDetail implements Comparable<PurchaseDetail>{    
    private Integer IdPurchase;
    private Integer IdDetail;
    private Integer IdItem;
    private Integer Amount;
    private Float Price;

    public Integer getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        IdPurchase = idPurchase;
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

    public PurchaseDetail(Integer idPurchase, Integer idDetail, Integer idItem, Integer amount, Float price) {
        IdPurchase = idPurchase;
        IdDetail = idDetail;
        IdItem = idItem;
        Amount = amount;
        Price = price;
    }

    @Override
    public String toString(){
        return "OrderDetail:"+
                ",IdOrder= "+IdPurchase+'\''+
                ",IdDetail= "+IdDetail+'\''+
                ",IdItem= "+IdItem+
                ",IdAmount= "+Amount+
                ",Price= "+Price+' ';
    }
    
    @Override
    public int compareTo(PurchaseDetail another){
        return 0;
    }
}

