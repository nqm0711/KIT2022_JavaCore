package BTVN.Day8.stockEx;

import java.util.Date;

public class Transaction {
    private int tranID;
    private String idStock;
    private String idBuyer;
    private String idSeller;
    private int amount;
    private float price;
    private Date date;

    public Transaction(String idStock, String idBuyer, String idSeller, int amount, float price, Date date) {
        this.idStock = idStock;
        this.idBuyer = idBuyer;
        this.idSeller = idSeller;
        this.amount = amount;
        this.price = price;
        this.date = date;
    }

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    public String getIdBuyer() {
        return idBuyer;
    }

    public void setIdBuyer(String idBuyer) {
        this.idBuyer = idBuyer;
    }

    public String getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(String idSeller) {
        this.idSeller = idSeller;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tranID=" + tranID +
                ", idStock='" + idStock + '\'' +
                ", idBuyer='" + idBuyer + '\'' +
                ", idSeller='" + idSeller + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
