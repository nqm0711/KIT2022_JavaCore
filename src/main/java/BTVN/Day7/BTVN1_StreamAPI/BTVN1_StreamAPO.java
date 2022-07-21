package BTVN.Day7.BTVN1_StreamAPI;

import java.util.*;
import java.util.stream.*;

public class BTVN1_StreamAPO {
    public static void main(String[] args) {
        List <Customer> lstCust = new ArrayList<>();
        List <Transaction>lstTrans = new ArrayList<>();
        //String name, String address
        Customer Chung = new Customer("Chung","Ha Noi");
        Customer The = new Customer("The","Khuat Duy Tien");
        Customer Tuan = new Customer("Tuan","Ha Noi");
        lstCust.add(The);
        lstCust.add(Chung);
        lstCust.add(Tuan);
        //Customer trader, Integer year, String prodName, Integer amount
        Transaction transaction1 = new Transaction(Chung,2020,"Rice",10);
        Transaction transaction2 = new Transaction(The,2021,"Cake",20);
        Transaction transaction3 = new Transaction(Tuan,2021,"Underwear",6);
        lstTrans.add(transaction1);
        lstTrans.add(transaction2);
        lstTrans.add(transaction3);
        lstTrans.stream().filter(p -> p.getYear() == 2021).toList().stream().sorted().forEach(System.out::println);
        lstCust.stream().distinct().forEach();

    }
}
