package Basic.Day8.StockExchange.StockExTuLam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.*;


class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        int result = 0;
        if (o1.getType() == 1&&o2.getType() ==1&&o2.getPrice()<o1.getPrice()){result = (int) (o2.getPrice() - o1.getPrice());}
        else if (o1.getType() == 2&&o2.getType() == 2&&o2.getPrice()<o1.getPrice()){result = (int) (o1.getPrice() - o2.getPrice());}
        return result;
    }
}


public class KhopLenhDemo {
    public static void main(String[] args) throws ParseException {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//        Mỗi Stock:
//          - Hàng đợi mua
//          - Hàng đợi bán

        Map<String,Stock> hm = new HashMap<>();

        Stock fpt = new Stock("FPT");
        Stock vnpt = new Stock("VNPT");
        hm.put("FPT", fpt);
        hm.put("VNPT", vnpt);


//      Tạo Trader
        Trader minh = new Trader("Minh");
        Trader the = new Trader("The");
        Trader chung = new Trader("Chung");


        Map<String, PriorityQueue<Order>> hm_st_Sellp = new HashMap<>();
        Map<String, PriorityQueue<Order>> hm_st_Buyq = new HashMap<>();


        for(String sIDStock: hm.keySet()){
            hm_st_Sellp.put(sIDStock, new PriorityQueue<Order>(100,new OrderComparator()));
            hm_st_Buyq.put(sIDStock, new PriorityQueue<Order>(100,new OrderComparator()));
        }

        //1
//      String orderID, Date orderDate, Integer type, String sIDStock, Trader sIDtrader, Integer amount, Float price



        Order order1= new Order("Or01",date.parse("2015-01-22"),1,"FPT",the,130,100.00f);
        Order order2= new Order("Or02",date.parse("2015-01-22"),2,"FPT",chung,100,50.00f);
        Order order3 = new Order("Or03",date.parse("2015-01-22"),2,"FPT",minh,30,90.00f);



//      String transID, Date transDate, String sIDStock, String orderSellID, String sSellIDTrader, String orderBuyID, String sBuyIDTrader, Integer amount, Float price
        List <Transaction> transactionList = new ArrayList<>();


// --------------------------------------------------------------------------------------------------------------------
        PriorityQueue<Order> buyQ_FPT = hm_st_Buyq.get("FPT");
        PriorityQueue<Order> sellQ_FPT = hm_st_Sellp.get("FPT");


        buyQ_FPT.add(order1);
        sellQ_FPT.add(order2);
        sellQ_FPT.add(order3);

//      Khớp lệnh




//      String transID, Date transDate, String sIDStock, String orderSellID, String sSellIDTrader, String orderBuyID, String sBuyIDTrader, Integer amount, Float price
            int totalBuyAmount = buyQ_FPT.stream().mapToInt(Order::getAmount).sum();
            int totalSellAmount = sellQ_FPT.stream().mapToInt(Order::getAmount).sum();
            int i = 1;
            while ( totalBuyAmount > 0 && totalSellAmount >0 ){
                Order peekBuy = buyQ_FPT.peek();
                Order peekSell = sellQ_FPT.peek();
                assert peekBuy != null;
                assert peekSell != null;
                if (peekBuy.getPrice() < peekSell.getPrice()) break;
                else {
                    int txAmount = peekBuy.getAmount()> peekSell.getAmount() ? peekSell.getAmount() : peekBuy.getAmount();
                    transactionList.add(new Transaction("tx00"+i,peekBuy.getOrderDate(),"FPT",peekSell.getOrderID(),peekSell.getsIDtrader(),peekBuy.getOrderID(),peekBuy.getsIDtrader(),txAmount, peekSell.getPrice()));
                    if (peekBuy.getAmount()> peekSell.getAmount()) {
                        sellQ_FPT.remove(peekSell);
                        peekBuy.setAmount(peekBuy.getAmount()- peekSell.getAmount());
                    } else if (peekBuy.getAmount()< peekSell.getAmount()) {
                        buyQ_FPT.remove(peekBuy);
                        peekSell.setAmount(peekSell.getAmount()- peekBuy.getAmount());
                    }
                    else {
                        buyQ_FPT.remove(peekBuy);
                        sellQ_FPT.remove(peekSell);
                    }
                    totalSellAmount -=txAmount;
                    totalBuyAmount -=txAmount;
                }
                i++;
            }
            System.out.println(transactionList);
        }
    }
