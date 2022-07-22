/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

/**
 *
 * @author Admin
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class CustomizeDistinct {
    // Truyền vào một Function trả về một Predicate

    private static <T> Predicate<T> distinctByKey(final Function<? super T, String> key) {
        final Map<String, Boolean> seen;
        seen = new ConcurrentHashMap<>();
        return t -> {
            String st = key.apply(t);
            /*This method returns null (if there was no mapping with the provided key before or it was mapped to a null value) 
           or current value associated with the provided key.
             */
            return seen.putIfAbsent(st, Boolean.TRUE) == null;
        };
    }

    private static <T> Predicate<T> distinctByKeys(final Function<? super T, ?>... keyExtractors) {
        final Map<List<?>, Boolean> seen;
        seen = new ConcurrentHashMap<>();
        return t -> {
            final List<?> keys = Arrays.stream(keyExtractors)
                    .map(ke -> ke.apply(t))
                    .collect(Collectors.toList());
            return seen.putIfAbsent(keys, Boolean.TRUE) == null;
        };
    }

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

//2.2. In ra danh sách các địa chỉ của Customer (trùng thì loại)
        System.out.println("2.2 Distinct"); 
        List<String> lstCity = transactions.stream()
                .map(t -> t.getCustomer().getCity())
                .distinct().collect(Collectors.toList());
        for (String ct : lstCity) {
            System.out.println(ct);
        }
//Cách 2: 
        System.out.println("----");
        transactions.stream().filter(distinctByKey(t -> t.getCustomer().getCity()))
                .forEach(System.out::println);
//Cách 3:
        System.out.println("----");
        transactions.stream().filter(distinctByKeys(t -> t.getCustomer().getCity(), t -> t.getProdName()))
                .forEach(System.out::println);

//2.3. Xác định tất cả các khách hàng chung một địa chỉ nào đó, sort by name của khách hàng và in ra. 
        System.out.println("2.3  ");
        transactions.stream().filter(t -> t.getCustomer().getCity().equalsIgnoreCase("Cambridge"))
                .map(t -> t.getCustomer())
                .filter(distinctByKey(t -> t.toString()))
                .sorted((x, y) -> x.getName().compareTo(y.getName()))
                .forEach(System.out::println);
        System.out.println("----");
        transactions.stream().filter(t -> t.getCustomer().getCity().equalsIgnoreCase("Cambridge"))
                .sorted((x, y) -> x.getCustomer().getName().compareTo(y.getCustomer().getName()))
                .forEach(System.out::println);

 
    }
}
