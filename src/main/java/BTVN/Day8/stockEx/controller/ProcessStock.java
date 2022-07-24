/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVN.Day8.stockEx.controller;


import BTVN.Day8.stockEx.Stock;
import BTVN.Day8.stockEx.Trader;

import java.sql.*;
import java.util.ArrayList;

public class ProcessStock {
    public ArrayList getStocks(Connection conn) {
        ArrayList<String> Stocks = new ArrayList<>();
        String getStockQuery = "select sIDStock from StockTable";

        if (conn != null) {
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(getStockQuery);
                while (rs.next()){
                    Stocks.add(rs.getString(1));
                }
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Stocks;
    }

    public void insertStocks(Connection conn, Stock stock) {
        String insertTraderQuery = "INSERT INTO StockTable (sIDStock,  StockName,  Company) "
                + " VALUES(?,?,?);";
        if (conn != null) {
            try {
                PreparedStatement prest = conn.prepareStatement(insertTraderQuery);
                prest.setString(1, stock.getsIDStock());
                prest.setString(2, stock.getStockName());
                prest.setString(3, stock.getCompany());
                prest.executeUpdate();

                prest.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
