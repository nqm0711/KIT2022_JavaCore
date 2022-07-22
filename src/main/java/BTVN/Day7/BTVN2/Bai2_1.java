/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTVN.Day7.BTVN2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Bai2_1 {

    public static void main(String[] agrs) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        TreeMap<Order, ArrayList<OrderDetail>> tm = new TreeMap<>();
        Order or1 = new Order(11, dateFormat.parse("2022-08-06"), "Cus01");
        Order or2 = new Order(2, dateFormat.parse("2022-08-06"), "Cus02");
        ArrayList<OrderDetail> list = new ArrayList<>();
        ArrayList<OrderDetail> list1 = new ArrayList<>();
        OrderDetail orDetail1 = new OrderDetail(11, 1, 1, 10, 100F);
        OrderDetail orDetail2 = new OrderDetail(11, 2, 5, 7, 40F);
        OrderDetail orDetail3 = new OrderDetail(2, 3, 3, 1110, 100F);
        OrderDetail orDetail4 = new OrderDetail(2, 4, 7, 7, 30F);
        list.add(orDetail1);
        list.add(orDetail2);
        list1.add(orDetail3);
        list1.add(orDetail4);
        tm.put(or1, list);
        tm.put(or2, list1);
//      Bài 2.1.1. Tìm hóa đơn có tổng số lượng lớn nhất
        Integer Totalmax = tm.values().stream().map(orderDetails -> orderDetails.stream().mapToInt(OrderDetail::getAmount).sum()).max(Integer::max).get();
        tm.entrySet().stream().filter(en->en.getValue().stream().mapToInt(OrderDetail::getAmount).sum()==Totalmax).forEach(System.out::println);
    }
}
