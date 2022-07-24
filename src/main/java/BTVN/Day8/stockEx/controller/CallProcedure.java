package BTVN.Day8.stockEx.controller;

import java.sql.*;

public class CallProcedure {
    public void callgetAllTxMoney(Connection conn) {
        if (conn != null) {
            try {
                CallableStatement statement = conn.prepareCall("{call getAllTxMoney()}");
                System.out.println("Tính tổng số tiền giao dịch");
                System.out.println("================================");
                boolean hadResults = statement.execute();
                while (hadResults) {
                    ResultSet resultSet = statement.getResultSet();
                    // process result set
                    while (resultSet.next()) {
                        System.out.println("Tổng số tiền giao dịch :"+resultSet.getString(1));
                    }
                    hadResults = statement.getMoreResults();
                }
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void callgetTxByStocks(Connection conn) {
        if (conn != null) {
            try {
                CallableStatement statement = conn.prepareCall("{call getgetTxByStocks()}");
                System.out.println("Lấy ra danh sách cổ phiếu với tổng số tiền giao dịch tương ứng;");
                System.out.println("================================");
                boolean hadResults = statement.execute();
                while (hadResults) {
                    ResultSet resultSet = statement.getResultSet();
                    // process result set
                    while (resultSet.next()) {
                        System.out.println("Mã cổ phiếu :"+resultSet.getString(1) +
                                " Tổng số tiền giao dịch "+ resultSet.getString(2));
                    }
                    hadResults = statement.getMoreResults();
                }
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void callgetHighestPriceStock(Connection conn) {
        if (conn != null) {
            try {
                CallableStatement statement = conn.prepareCall("{call getgetHighestPriceStock()}");
                System.out.println("Lấy danh sách cổ phiếu có số tiền giao dịch lớn nhất");
                System.out.println("================================");
                boolean hadResults = statement.execute();
                while (hadResults) {
                    ResultSet resultSet = statement.getResultSet();
                    // process result set
                    while (resultSet.next()) {
                        System.out.println("Mã cổ phiếu :"+resultSet.getString(1) +
                                " Tổng số tiền giao dịch "+ resultSet.getString(2));
                    }
                    hadResults = statement.getMoreResults();
                }
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void callMaxAmountBoughtByIDStock(Connection conn) {
        if (conn != null) {
            try {
                CallableStatement statement = conn.prepareCall("{call MaxAmountBoughtByIDStock()}");
                System.out.println("Lấy ra danh sách những người mua nhiều cố phiếu nhất của từng mã cổ phiếu");
                System.out.println("================================");
                boolean hadResults = statement.execute();
                while (hadResults) {
                    ResultSet resultSet = statement.getResultSet();
                    // process result set
                    while (resultSet.next()) {
                        System.out.println("Mã cổ phiếu :"+resultSet.getString(3) +
                                " Số lượng lớn nhất "+ resultSet.getString(4)+
                                " Người mua :"+resultSet.getString(2) + " ID "+resultSet.getString(1));
                    }
                    hadResults = statement.getMoreResults();
                }
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}
