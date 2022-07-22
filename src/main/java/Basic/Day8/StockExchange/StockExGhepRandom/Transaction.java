package Basic.Day8.StockExchange.StockExGhepRandom;

import java.util.Date;

public class Transaction {
    //TransID, TransDate, sIDStock, OrderSellID, sSellIDTrader, OrderBuyID, sBuyIDTrader, Amount, Price

    private String transID;
    private Date transDate;
    private String sIDStock;
    private String OrderSellID;
    private Trader sSellIDTrader;
    private String OrderBuyID;
    private Trader sBuyIDTrader;
    private Integer amount;
    private Float price;

    public Transaction(String transID, Date transDate, String sIDStock, String orderSellID, Trader sSellIDTrader, String orderBuyID, Trader sBuyIDTrader, Integer amount, Float price) {
        this.transID = transID;
        this.transDate = transDate;
        this.sIDStock = sIDStock;
        OrderSellID = orderSellID;
        this.sSellIDTrader = sSellIDTrader;
        OrderBuyID = orderBuyID;
        this.sBuyIDTrader = sBuyIDTrader;
        this.amount = amount;
        this.price = price;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getsIDStock() {
        return sIDStock;
    }

    public void setsIDStock(String sIDStock) {
        this.sIDStock = sIDStock;
    }

    public String getOrderSellID() {
        return OrderSellID;
    }

    public void setOrderSellID(String orderSellID) {
        OrderSellID = orderSellID;
    }

    public Trader getsSellIDTrader() {
        return sSellIDTrader;
    }

    public void setsSellIDTrader(Trader sSellIDTrader) {
        this.sSellIDTrader = sSellIDTrader;
    }

    public String getOrderBuyID() {
        return OrderBuyID;
    }

    public void setOrderBuyID(String orderBuyID) {
        OrderBuyID = orderBuyID;
    }

    public Trader getsBuyIDTrader() {
        return sBuyIDTrader;
    }

    public void setsBuyIDTrader(Trader sBuyIDTrader) {
        this.sBuyIDTrader = sBuyIDTrader;
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
        return "Transaction{" +
                "transID='" + transID + '\'' +
                ", transDate=" + transDate +
                ", sIDStock='" + sIDStock + '\'' +
                ", OrderSellID='" + OrderSellID + '\'' +
                ", sSellIDTrader=" + sSellIDTrader +
                ", OrderBuyID='" + OrderBuyID + '\'' +
                ", sBuyIDTrader=" + sBuyIDTrader +
                ", amount=" + amount +
                ", price=" + price +
                '}'+"\n";
    }
}
