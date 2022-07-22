package Basic.Day8.StockExchange.StockExGhepRandom;

import java.util.Date;

public class Order {
    //OrderID, OrderDate, sIDTrader, sIDStock, Amount, Price, Type
    private String orderID;
    private Date orderDate;
    private Integer type;
    private String sIDStock;
    private Trader sIDtrader;
    private Integer amount;
    private Float price;

    public Order(String orderID, Date orderDate, Integer type, String sIDStock, Trader sIDtrader, Integer amount, Float price) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.type = type;
        this.sIDStock = sIDStock;
        this.sIDtrader = sIDtrader;
        this.amount = amount;
        this.price = price;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getsIDStock() {
        return sIDStock;
    }

    public void setsIDStock(String sIDStock) {
        this.sIDStock = sIDStock;
    }

    public Trader getsIDtrader() {
        return sIDtrader;
    }

    public void setsIDtrader(Trader sIDtrader) {
        this.sIDtrader = sIDtrader;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDate=" + orderDate +
                ", type=" + type +
                ", sIDStock='" + sIDStock + '\'' +
                ", sIDtrader=" + sIDtrader +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
