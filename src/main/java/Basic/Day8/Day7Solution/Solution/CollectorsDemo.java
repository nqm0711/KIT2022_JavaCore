/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Admin
 */
public class CollectorsDemo {

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
        System.out.println("toList");
        transactions.stream().collect(Collectors.toList())
                .forEach(System.out::println);

        List<Transaction> lst1 = transactions.stream().collect(Collectors.toList());
        System.out.println("toSet");
        transactions.stream().collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("toMap");
        Map<String, Transaction> mp2 = transactions.stream()
                .collect(Collectors.toMap(t -> t.getProdName() + t.getYear().toString(), Function.identity()));
        System.out.println(mp2);

        System.out.println("joining");
        String st1 = transactions.stream()
                .map(t -> t.getProdName())
                .collect(Collectors.joining());
        System.out.println("mapping");
        Set<String> custName = transactions.stream()
                .collect(Collectors.mapping(t -> t.getCustomer().getCity(), Collectors.toSet()));
        System.out.println(custName);

        System.out.println("partitioning");
        Map<Boolean, List<Transaction>> mpPart = transactions.stream()
                .collect(Collectors.partitioningBy(t -> t.getYear() > 2011));
        System.out.println(mpPart);
        
        System.out.println("reducing");
        
        
        
        System.out.println("GroupingBy");
        Map<Integer, List<Transaction>> mp = transactions.stream().collect(Collectors.groupingBy(t -> t.getYear()));
        for (Integer it : mp.keySet()) {
            List<Transaction> lst = mp.get(it);
            System.out.println("==========");
            for (Transaction tr : lst) {
                System.out.println(tr.toString());
            }
        }

    }
}
