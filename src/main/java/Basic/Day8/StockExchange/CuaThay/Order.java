/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic.Day8.StockExchange.CuaThay;

/**
 *
 * @author Admin
 */
public class Order implements Comparable<Order>{ 
      private Integer type;// 1-- mua, 2-- bán
      private String sIDStock;// 
      private String sIDTrader;//
      private Integer amount;//
      private Float price;//
    Order (Integer type, String sIDStock,     String sIDTrader,   Integer amount, Float price) {
        this.type=type;
        this.sIDStock=sIDStock;
        this.sIDTrader=sIDTrader;
        this.amount=amount;
        this.price=price;
    }

    @Override
    public int compareTo(Order o) {
      return  this.getPrice().compareTo(o.getPrice());
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the sIDStock
     */
    public String getsIDStock() {
        return sIDStock;
    }

    /**
     * @param sIDStock the sIDStock to set
     */
    public void setsIDStock(String sIDStock) {
        this.sIDStock = sIDStock;
    }

    /**
     * @return the sIDTrader
     */
    public String getsIDTrader() {
        return sIDTrader;
    }

    /**
     * @param sIDTrader the sIDTrader to set
     */
    public void setsIDTrader(String sIDTrader) {
        this.sIDTrader = sIDTrader;
    }

    /**
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }
}
