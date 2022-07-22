/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

/**
 *
 * @author Admin
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import jdbcSQLServer.transact.TransactDemo;

/**
 *
 * @author Admin
 */
public class TimTatcaCacGiaodichMax {
    

    public static void main(String[] args) {
        Customer raoul = new Customer("Raoul", "Cambridge");
        Customer mario = new Customer("Mario", "Milan");
        Customer alan = new Customer("Alan", "Cambridge");
        Customer brain = new Customer("Brain", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brain, 2011, "A1", 300),
                new Transaction(raoul, 2012, "A1", 1000),
                new Transaction(raoul, 2011, "C", 1000),
                new Transaction(mario, 2012, "E", 710),
                new Transaction(mario, 2012, "D", 300),
                new Transaction(alan, 2012, "B", 950)
        ); 
        // Cách 2
        List<Transaction> maxTrans = new ArrayList<>(); 
        
        transactions.stream().forEach( p -> {
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

        // Cách 3
        System.out.println("------groupingBy------");
        transactions.stream().collect( Collectors.groupingBy(t -> t.getAmount(), TreeMap::new, toList()))
                .lastEntry()// 
                .getValue()
                .forEach(System.out::println);

 
    }
}
