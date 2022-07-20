/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basic.Day6.Collection.Practices.Exercise.Ex2_Orders;

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
        ArrayList<OrderDetail> list1 = new ArrayList<>();
        ArrayList<OrderDetail> list2 = new ArrayList<>();
        OrderDetail orDetail1 = new OrderDetail(11, 1, 1, 10, 100F);
        OrderDetail orDetail2 = new OrderDetail(11, 2, 5, 7, 40F);
        OrderDetail orDetail3 = new OrderDetail(2, 3, 3, 1110, 100F);
        OrderDetail orDetail4 = new OrderDetail(2, 4, 7, 7, 30F);
        list1.add(orDetail1);
        list1.add(orDetail2);
        //list1.add(new OrderDetail(2, 3, 3, 10, 100F));
        list2.add(orDetail3);
        list2.add(orDetail4);
        tm.put(or1, list1);
        tm.put(or2, list2);


        int idSearch = 2;
        System.out.println("Get OrderDetail by IdOrder "+idSearch+ ":");
        for (Map.Entry<Order, ArrayList<OrderDetail>> entry : tm.entrySet()) {
            for (OrderDetail orDetail : entry.getValue()) {
                if (orDetail.getIdOrder() == idSearch) System.out.println(orDetail);
            }
        }

        int maxAmount = 0;
        int maxPrice = 0;
        int amount;
        int totalPrice;
        Integer IdSoLuongLonNhat=0;
        Integer IdGiaTriLonNhat=0;
        for (Map.Entry<Order, ArrayList<OrderDetail>> entry : tm.entrySet()) {
            amount = 0;
            totalPrice=0;
            for (OrderDetail orDetail : entry.getValue()) {
                amount+=orDetail.getAmount();
                totalPrice+=orDetail.getPrice()*orDetail.getAmount();
            }
            if (amount > maxAmount) {maxAmount = amount;IdSoLuongLonNhat = entry.getKey().getIdOrder();}
            if (totalPrice> maxPrice){maxPrice = totalPrice;IdGiaTriLonNhat = entry.getKey().getIdOrder();}
        }
        System.out.println("Đơn hàng có số lượng lớn nhất có "+maxAmount+" sản phẩm"+"là đơn có IdOrder: "+IdSoLuongLonNhat);
        System.out.println("Đơn hàng có giá trị lớn nhất có giá :"+maxPrice+"là đơn có IdOrder: "+IdGiaTriLonNhat);


    }
}