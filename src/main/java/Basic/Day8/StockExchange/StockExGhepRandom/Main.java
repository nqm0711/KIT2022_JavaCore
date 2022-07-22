/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic.Day8.StockExchange.StockExGhepRandom;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static void main(String[] args) throws ParseException {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String[] lstStock = {"VIN","SSB", "SHB", "EIB", "MSB", "OCB", "FPT"};
        Trader market = new Trader("Market");
        
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
        List<Transaction> transactionList = new ArrayList<>();
        int i =1;
        int j = 1;
        while (true) {
            // Lệnh mua, bán ngẫu nhiên
            int iIDStock = (int) Math.round(Math.random() * (lstStock.length - 1));
            double x = Math.random();
            int amount = (int) (Math.random()*10);
            Float price = (float) Math.random() * 1000;
            if (x < 0.5) {
                Order ord1 = new Order("Order"+i,date.parse("2015-01-22"),1,lstStock[iIDStock],market,amount,price);
                PriorityQueue<Order> buyQ = hm_st_Buyq.get(lstStock[iIDStock]);
                buyQ.add(ord1);
            } else {
                Order ord2 = new Order("Order"+i,date.parse("2015-01-22"),2,lstStock[iIDStock],market,amount,price);
                PriorityQueue<Order> sellQ = hm_st_Sellq.get(lstStock[iIDStock]);
                sellQ.add(ord2);
            }
            // Khớp lệnh 
            Queue<Order> sQ = hm_st_Sellq.get(lstStock[iIDStock]);
            Queue<Order> bQ = hm_st_Buyq.get(lstStock[iIDStock]);
            //Bổ sung vào đây
            while(!bQ.isEmpty() && !sQ.isEmpty()) {
//            System.out.println("buy size: " + bQ_FPT.size());
//            System.out.println("sell size: " + sQ_FPT.size());
                Order buyOrder = bQ.peek();
                Order sellOrder = sQ.peek();
                if(buyOrder.getPrice() >= sellOrder.getPrice() && Objects.equals(buyOrder.getsIDStock(), sellOrder.getsIDStock())) {
                    int txAmount = buyOrder.getAmount()> sellOrder.getAmount() ? sellOrder.getAmount() : buyOrder.getAmount();
                    transactionList.add(new Transaction("tx00"+j,buyOrder.getOrderDate(),buyOrder.getsIDStock(),sellOrder.getOrderID(),sellOrder.getsIDtrader(),buyOrder.getOrderID(),buyOrder.getsIDtrader(),txAmount, sellOrder.getPrice()));
                    if (buyOrder.getAmount()> sellOrder.getAmount()) {
                        sQ.remove(sellOrder);
                        buyOrder.setAmount(buyOrder.getAmount()- sellOrder.getAmount());
                    } else if (buyOrder.getAmount()< sellOrder.getAmount()) {
                        bQ.remove(buyOrder);
                        sellOrder.setAmount(sellOrder.getAmount()- buyOrder.getAmount());
                    }
                    else {
                        bQ.remove(buyOrder);
                        sQ.remove(sellOrder);
                    }
                } else {
                    break;
                }
            j++;
            }
            System.out.println(transactionList);
        }
    }

}
