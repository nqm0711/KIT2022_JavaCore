package Basic.Day6.Collection.Practices.Exercise.Ex2_DonHang;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Bai2_1 {
    public static void main(String[] agrs) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        TreeMap<Order, ArrayList<OrderDetail>> tm = new TreeMap<>();
        Order order1 = new Order(1, dateFormat.parse("2020-06-08"), "Cus01");
        Order order2 = new Order(2, dateFormat.parse("2020-02-04"), "Cus02");
        ArrayList<OrderDetail> list1 = new ArrayList<>();
        ArrayList<OrderDetail> list2 = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail(1, 1, 1, 5, 100F);
        OrderDetail orderDetail2 = new OrderDetail(2, 2, 3, 4, 40F);
        OrderDetail orderDetail3 = new OrderDetail(1, 3, 5, 3, 100F);
        OrderDetail orderDetail4 = new OrderDetail(2, 4, 7, 2, 30F);
        list1.add(new OrderDetail(2, 3, 3, 10, 100F));
        list1.add(orderDetail1);
        list1.add(orderDetail3);
        list2.add(orderDetail2);
        list2.add(orderDetail4);
        tm.put(order1,list1);
        tm.put(order2,list2);
        System.out.println(tm.get(order1)); // list1
        System.out.println(tm.get(order2)); // list2
        int max = 0;
        Integer idNo=0;
        for (Map.Entry<Order,ArrayList<OrderDetail>> entry : tm.entrySet()) {
            System.out.println(entry);
            int amount = 0;
            for (OrderDetail detail: entry.getValue()){
                amount+=detail.getAmount();
                System.out.println(amount);
            }
            if (amount > max) {max = amount; idNo=entry.getKey().getIdOrder();}
        }
        System.out.println("Số lượng lớn nhất :"+max + " Order ID :" + idNo);
    }
}
