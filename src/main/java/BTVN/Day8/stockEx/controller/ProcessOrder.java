/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVN.Day8.stockEx.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import BTVN.Day8.stockEx.Order;

public class ProcessOrder {

   public void insertOrder(Connection conn, Order ord) {
        String insertOrderQuery = "INSERT INTO OrderTable (type,  sIDStock,  sIDTrader,  amount, price) "
                + " VALUES(?,?,?,?,?);";
        if (conn != null) {
            try {
                PreparedStatement prest = conn.prepareStatement(insertOrderQuery);
                prest.setInt(1, ord.getType());
                prest.setString(2, ord.getsIDStock()); 
                prest.setString(3, ord.getsIDTrader());
                prest.setInt(4, ord.getAmount());
                prest.setFloat(5, ord.getPrice());
                prest.executeUpdate();

                prest.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
