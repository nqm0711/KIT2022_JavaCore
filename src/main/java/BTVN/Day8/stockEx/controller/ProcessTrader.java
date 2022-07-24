/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVN.Day8.stockEx.controller;


import BTVN.Day8.stockEx.Order;
import BTVN.Day8.stockEx.Trader;

import java.sql.*;
import java.util.ArrayList;

public class ProcessTrader {
    public ArrayList getTraders(Connection conn) {
        ArrayList<String> Traders = new ArrayList<>();
        String getStockQuery = "select sIDTrader from TraderTable";

        if (conn != null) {
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(getStockQuery);
                while (rs.next()){
                    Traders.add(rs.getString(1));
                }
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Traders;
    }

    public void insertTrader(Connection conn, Trader trader) {
        String insertTraderQuery = "INSERT INTO TraderTable (sIDTrader,  TraderName,  TraderAddress,  TraderFund) "
                + " VALUES(?,?,?,?);";
        if (conn != null) {
            try {
                PreparedStatement prest = conn.prepareStatement(insertTraderQuery);
                prest.setString(1, trader.getsIDTrader());
                prest.setString(2, trader.getName());
                prest.setString(3, trader.getAddress());
                prest.setFloat(4, trader.getFunds());
                prest.executeUpdate();

                prest.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
