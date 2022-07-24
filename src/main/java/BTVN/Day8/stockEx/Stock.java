/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVN.Day8.stockEx;


public class Stock {
    private String sIDStock;
    private String stockName;
    private String company;

    public Stock(String sIDStock, String stockName, String company) {
        this.sIDStock = sIDStock;
        this.stockName = stockName;
        this.company = company;
    }

    public Stock(String sIDStock) {
        this.sIDStock = sIDStock;
    }

    public String getsIDStock() {
        return sIDStock;
    }

    public void setsIDStock(String sIDStock) {
        this.sIDStock = sIDStock;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
