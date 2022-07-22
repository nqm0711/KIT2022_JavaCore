package Basic.Day8.Day7Solution;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class BTVN1_StreamAPI {
    public static void main(String[] args) {
        List <Customer> lstCust = new ArrayList<>();
        List <Transaction>lstTrans = new ArrayList<>();
        //String name, String address
        Customer Chung = new Customer("Chung","Ha Noi");
        Customer The = new Customer("The","Khuat Duy Tien");
        Customer Tuan = new Customer("Tuan","Ha Noi");
        Customer Luyen = new Customer("Luyen","Ha Noi");
        lstCust.add(The);
        lstCust.add(Chung);
        lstCust.add(Tuan);
        lstCust.add(Luyen);
        //Customer trader, Integer year, String prodName, Integer amount
        Transaction transaction1 = new Transaction(Chung,2020,"Rice",10);
        Transaction transaction2 = new Transaction(The,2021,"Cake",20);
        Transaction transaction3 = new Transaction(Tuan,2021,"Glass",6);
        Transaction transaction4 = new Transaction(Luyen,2021,"Iphone 15 Ultra XS Max Vip Pro",2);
        lstTrans.add(transaction1);
        lstTrans.add(transaction2);
        lstTrans.add(transaction3);
        lstTrans.add(transaction4);

//        Xác định tất cả giao dịch số lượng amount lớn nhất

        // Cách 2
        List<Transaction> maxTrans = new ArrayList<>();

        lstTrans.stream().forEach( p -> {
            if (maxTrans.size() == 0) {
                maxTrans.add(p);// giả thiết trans là max
            } else if (p.getAmount() == maxTrans.get(0).getAmount()) {
                maxTrans.add(p);
            } else if (maxTrans.get(0).getAmount() < p.getAmount()) {
                maxTrans.clear();
                maxTrans.add(p);// cập nhất giả thiết
            }
        });
        maxTrans.stream().forEach(System.out::println);


        // Máy gợi ý
        System.out.println("\n");
        List<Transaction> maxTrans2 = new ArrayList<>();
        lstTrans.forEach(p -> {
            if (maxTrans2.size() == 0) {
                maxTrans2.add(p);// giả thiết trans là max
            } else if (p.getAmount() == maxTrans2.get(0).getAmount()) {
                maxTrans2.add(p);
            } else if (maxTrans2.get(0).getAmount() < p.getAmount()) {
                maxTrans2.clear();
                maxTrans2.add(p);// cập nhất giả thiết
            }
        });
        maxTrans2.forEach(System.out::println);
        System.out.println("\n");

        // Cách 3
        System.out.println("------groupingBy------");
        lstTrans.stream().collect( Collectors.groupingBy(t -> t.getAmount(), TreeMap::new, toList()))
                .lastEntry()// 
                .getValue()
                .forEach(System.out::println);

    }
}
