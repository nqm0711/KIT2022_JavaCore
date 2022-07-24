package BTVN.Day8.stockEx.controller;

import BTVN.Day8.stockEx.Transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProcessTransaction {


    public void insertTx(Connection conn, Transaction Tx) {
        String insertTxQuery = "INSERT INTO TransactionTable (idStock, idBuyer, idSeller, amount, price, date) "
                + " VALUES(?,?,?,?,?,?);";
        if (conn != null) {
            try {
                PreparedStatement prest = conn.prepareStatement(insertTxQuery);
                prest.setString(1, Tx.getIdStock());
                prest.setString(2, Tx.getIdBuyer());
                prest.setString(3, Tx.getIdSeller());
                prest.setInt(4, Tx.getAmount());
                prest.setFloat(5, Tx.getPrice());
                prest.setDate(6, (Date) Tx.getDate());
                prest.executeUpdate();

                prest.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
