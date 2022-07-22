package Basic.Day8.StockExchange.CuaThay;

import java.util.Date;

public class Transaction {
    private int tranID;
    static int ID = 0;
    String idStock;
    String idBuyer;
    String idSeller;
    int amount;
    float price;
    Date date;

    public Transaction(String idStock, String idBuyer, String idSeller, int amount, float price) {
        this.tranID = ++ID;
        this.idStock = idStock;
        this.idBuyer = idBuyer;
        this.idSeller = idSeller;
        this.amount = amount;
        this.price = price;
    }

    public Transaction() {
        this.tranID = ++ID;
    }

    @Override
    public String toString() {
        return "Transantion{" +
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
