/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

/**
 *
 * @author Hung    
 */
public class Transaction {  
    private Customer trader;
    private Integer year;// Năm thực hiện giao dịch
    private String prodName;// Tên sản phẩm
    private Integer amount; // Số lượng
 public Transaction(Customer t, int y, String name, int v){
     trader=t; year=y; prodName=name; amount=v;
 }
    public Customer getCustomer() {
        return trader;
    } 
    public void setCustomer(Customer trader) {
        this.trader = trader;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    } 
    public void setYear(Integer year) {
        this.year = year;
    } 
    
     @Override
    public String toString(){
        return  trader.toString()+" Transaction (Year: " + year 
                +", ProdName: "+ getProdName()+", Amount: "+ getAmount() +")";
    }

    /**
     * @return the prodName
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * @param prodName the prodName to set
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
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
}
