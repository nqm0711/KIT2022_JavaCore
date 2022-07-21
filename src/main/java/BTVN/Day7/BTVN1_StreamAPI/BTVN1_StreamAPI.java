package BTVN.Day7.BTVN1_StreamAPI;

import java.util.*;

import static java.util.Comparator.comparing;

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

//        In giao dịch 2021 sắp xếp theo amount
        System.out.println("In giao dịch 2021 sắp xếp theo amount");
        lstTrans.stream().filter(ts -> ts.getYear() == 2021).toList().stream().sorted().forEach(System.out::println);
//        In ra danh sách địa chỉ duy nhất
        System.out.println("In ra danh sách địa chỉ duy nhất");
        lstCust.stream().map(Customer::getAddress).distinct().forEach(System.out::println);
//        In ra danh sách customers với địa chỉ duy nhất
        System.out.println("In ra danh sách customers với địa chỉ duy nhất");
        lstCust.stream().distinct().forEach(System.out::println);
//        In ra danh sách customers với địa chỉ ở Hà Nội và sắp xếp theo tên
        System.out.println("In ra danh sách customers với địa chỉ ở Hà Nội và sắp xếp theo tên");
        lstCust.stream().filter(cus -> cus.getAddress().equals("Ha Noi")).sorted(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).forEach(System.out::println);



    }
}
