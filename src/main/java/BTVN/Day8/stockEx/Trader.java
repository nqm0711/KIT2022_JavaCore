/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVN.Day8.stockEx;


public class Trader {
    private String sIDTrader;
    private String Address;
    private float Funds;
    private String Name;

    public Trader(String sIDTrader, String address, float funds, String name) {
        this.sIDTrader = sIDTrader;
        Address = address;
        Funds = funds;
        Name = name;
    }

    public Trader(String sIDTrader, float funds, String name) {
        this.sIDTrader = sIDTrader;
        Funds = funds;
        Name = name;
    }

    public Trader(String sIDTrader) {
        this.sIDTrader = sIDTrader;
    }

    public String getsIDTrader() {
        return sIDTrader;
    }

    public void setsIDTrader(String sIDTrader) {
        this.sIDTrader = sIDTrader;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getFunds() {
        return Funds;
    }

    public void setFunds(float funds) {
        Funds = funds;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "sIDTrader='" + sIDTrader + '\'' +
                ", Address='" + Address + '\'' +
                ", Funds=" + Funds +
                ", Name='" + Name + '\'' +
                '}';
    }
}
