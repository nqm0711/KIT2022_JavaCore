package BTVN.Day8.stockEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

import BTVN.Day8.stockEx.controller.*;

class PriceDesc implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o2.getPrice().compareTo(o1.getPrice());
    }
}

class PriceAsc implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}

public class Main {
    static String connectionUrl = "jdbc:sqlserver://Localhost:1433;"
            + "databaseName=StockExchange;user=sa;password=sa";
    // Declare the JDBC objects.
    static Connection conn = null;

    static {
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// buoc 1
            conn = DriverManager.getConnection(connectionUrl); // buoc 2  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public static void main(String[] args) {
//         -------------Declare Database Processes------------
        ProcessStock pStock = new ProcessStock();
        ProcessOrder pOrd = new ProcessOrder();
        ProcessTrader pTrader = new ProcessTrader();
        ProcessTransaction pTransaction = new ProcessTransaction();
        CallProcedure call = new CallProcedure();
//        -------------End declare  database processes------------

//  --------------------------------"VIC","SSB", "SHB", "EIB", "MSB", "OCB", "FPT"
//        Declare Stocks
        Stock vin = new Stock("VIC", "VIC", "TAP DOAN VINGROUP");
        Stock ssb = new Stock("SSB", "SSB", "Ngan hang TMCP Dong Nam A");
        Stock shb = new Stock("SHB", "SHB", "Ngan hang TMCP Sai Gon Ha Noi");
        Stock eib = new Stock("EIB", "EIB", "Ngan hang TMCP Xuat Nhap Khau VietNam");
        Stock msb = new Stock("MSB", "MSB", "Ngan hang TMCP Hang hai VietNam");
        Stock ocb = new Stock("OCB", "OCB", "Ngan hang TMCP Phuong Dong");
        Stock fpt = new Stock("FPT", "FPT", "CTCP FPT");

//        Insert Stocks Info to Database
        pStock.insertStocks(conn, vin);
        pStock.insertStocks(conn, ssb);
        pStock.insertStocks(conn, shb);
        pStock.insertStocks(conn, eib);
        pStock.insertStocks(conn, msb);
        pStock.insertStocks(conn, ocb);
        pStock.insertStocks(conn, fpt);
//  --------------------------------"Trader_1","Trader_2", "Trader_3", "Trader_4"
//        Declare Trader
        Trader tr1 = new Trader("Trader1", "Hanoi", 10000F, "Chung");
        Trader tr2 = new Trader("Trader2", "Hanoi", 10000F, "The");
        Trader tr3 = new Trader("Trader3", "Hanoi", 10000F, "Hai");
        Trader tr4 = new Trader("Trader4", "Hanoi", 10000F, "Tuan");

        pTrader.insertTrader(conn, tr1);
        pTrader.insertTrader(conn, tr2);
        pTrader.insertTrader(conn, tr3);
        pTrader.insertTrader(conn, tr4);


        //Get Stock List
        String[] lstStock = (String[]) pStock.getStocks(conn).toArray();
        // Get Trader List
        String[] lstTrader = (String[]) pTrader.getTraders(conn).toArray();


        Map<String, Stock> hm = new HashMap<>();
        for (String sId : lstStock) {
            Stock st = new Stock(sId);
            hm.put(sId, st);
        }

        Map<String, PriorityQueue<Order>> hm_st_Sellq = new HashMap<>();
        Map<String, PriorityQueue<Order>> hm_st_Buyq = new HashMap<>();

        for (String sIdStock : hm.keySet()) {
            hm_st_Sellq.put(sIdStock, new PriorityQueue<>(new PriceAsc()));
            hm_st_Buyq.put(sIdStock, new PriorityQueue<>(new PriceDesc()));
        }


        while (true) {
            // Lệnh mua, bán ngẫu nhiên
            int iIDStock = (int) Math.round(Math.random() * (lstStock.length - 1));
            int iIDTrader = (int) Math.round(Math.random() * (lstTrader.length - 1));
            double x = Math.random();
            int iAmount = (int) Math.round(Math.random() * 100);
            Float price = (float) Math.random() * 1000;
            Order ord;
            if (x < 0.5) {
                ord = new Order(1, lstStock[iIDStock], lstTrader[iIDTrader], iAmount, price);
                PriorityQueue<Order> bQ = hm_st_Buyq.get(lstStock[iIDStock]);
                bQ.add(ord);
            } else {
                ord = new Order(2, lstStock[iIDStock], lstTrader[iIDTrader], iAmount, price);
                PriorityQueue<Order> sQ = hm_st_Sellq.get(lstStock[iIDStock]);
                sQ.add(ord);
            }

            //Insert Order to Database
            pOrd.insertOrder(conn, ord);

            // Khớp lệnh
            Queue<Order> sQ = hm_st_Sellq.get(lstStock[iIDStock]);
            Queue<Order> bQ = hm_st_Buyq.get(lstStock[iIDStock]);

            //Tạo list chứa tất cả các transantion.
            List<Transaction> transactionList = new ArrayList<>();
            while (!bQ.isEmpty() && !sQ.isEmpty()) {
                Order buyOrder = bQ.peek();
                Order sellOrder = sQ.peek();
                if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                    int txAmount = buyOrder.getAmount() > sellOrder.getAmount() ? sellOrder.getAmount() : buyOrder.getAmount();
                    Transaction transaction = new Transaction(buyOrder.getsIDStock(), buyOrder.getsIDTrader(), sellOrder.getsIDTrader(), txAmount, sellOrder.getPrice(), (Date) new Date());
                    if (buyOrder.getAmount() < sellOrder.getAmount()) {
                        //cập nhật lại số lượng của chứng khoán của queue
                        sellOrder.setAmount(sellOrder.getAmount() - buyOrder.getAmount());
                        bQ.poll();
                    } else if (buyOrder.getAmount() > sellOrder.getAmount()) {
                        //cập nhật lại số lượng của chứng khoán của queue
                        buyOrder.setAmount(buyOrder.getAmount() - sellOrder.getAmount());
                        sQ.poll();
                    } else {
                        bQ.poll();
                        sQ.poll();
                    }
                    transactionList.add(transaction);

                    //Insert Tx to database

                    pTransaction.insertTx(conn, transaction);
                    System.out.println(transaction);
                } else {
                    break;
                }
            }
        }
    }
}
