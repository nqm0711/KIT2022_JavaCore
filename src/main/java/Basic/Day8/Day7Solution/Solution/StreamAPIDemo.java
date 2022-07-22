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
public class StreamAPIDemo {
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

//        2.1. Tìm tất cả các giao dịch thực hiện trong năm 2021 và sắp xếp chúng theo số lượng tăng dần.  
        //Cách 1 
        System.out.println("2.1  ");
        List<Transaction> c1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((x, y) -> x.getAmount().compareTo(y.getAmount()))
                .collect(Collectors.toList());
        for (Transaction t : c1) {
            System.out.println(t.toString());
        }
        // Cách 2
        System.out.println("----");
        transactions.stream().filter(t -> t.getYear().equals(2011))
                .sorted((x, y) -> x.getAmount().compareTo(y.getAmount()))
                .forEach(System.out::println);

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

//2.4. Sắp xếp tất cả khách hành theo tên và in ra. 
        System.out.println("C 2.4  ");
        transactions.stream()
                .map((t) -> t.getCustomer().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("-----------");
        transactions.stream()
                .map(t -> t.getCustomer())
                .filter(distinctByKey(t -> t.toString()))
                .sorted((x, y) -> x.getName().compareTo(y.getName()))
                .forEach(System.out::println);
//2.5. Kiểm tra xem có khách hàng ở địa chỉ nào đó hay không (y/n)?  
        System.out.println("C 2.5  ");
        Boolean b = transactions.stream()
                .anyMatch(t -> t.getCustomer().getCity().equals("Milan"));
        if (b) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
//2.6. Xác định số lượng (amount) lớn nhất xuất hiện trong các giao dịch và in ra.  
        System.out.println("C 2.6  ");
        Optional<Integer> first = transactions.stream()
                .map(Transaction::getAmount)
                .max(Integer::compareTo);
        //.max((x,y)->x.compareTo(y));
        if (first.isPresent()) {
            System.out.println(first.get());
        }
        System.out.println("------------");
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getAmount)
                .collect(Collectors.maxBy(Integer::compareTo));
        if (max.isPresent()) {
            transactions.stream()
                    .filter(t -> t.getAmount().equals(max.get()))
                    .forEach(System.out::println);
        }
        System.out.println("------------");
        Optional<Transaction> max2 = transactions.stream()
                .max((t1, t2) -> t1.getAmount().compareTo(t2.getAmount()));
        System.out.println(max2.get());

        // Cách 2
        List<Transaction> maxt = new ArrayList<>();

        transactions.stream().forEach(p -> {
            if (maxt.size() == 0) {
                maxt.add(p);
            } else if (p.getAmount() == maxt.get(0).getAmount()) {
                maxt.add(p);
            } else if (maxt.get(0).getAmount() < p.getAmount()) {
                maxt.clear();
                maxt.add(p);
            }
        });
        maxt.stream().forEach(System.out::println);

        // Cách 3s
        System.out.println("------groupingBy------");
        transactions.stream().collect(Collectors.groupingBy(t -> t.getAmount(), TreeMap::new, toList()))
                .lastEntry()
                .getValue()
                .forEach(System.out::println);

//2.7. Tính và in ra tổng số lượng trong các giao dịch của các khách hàng ở một địa chỉ nào đó 
        System.out.println("C 2.7  ");
        Optional<Integer> sum = transactions.stream()
                .map(t -> t.getAmount())
                .reduce((x, y) -> x + y);
        System.out.println("Sum=" + sum.get());
//2.8. Xác định và in ra giao dịch có số lượng nhỏ nhất  
        System.out.println("C 2.8  ");
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()));

        System.out.println(min.get());
        System.out.println("------groupingBy------");
        transactions.stream().collect(Collectors.groupingBy(t -> t.getAmount(), TreeMap::new, toList()))
                .firstEntry()
                .getValue()
                .forEach(System.out::println);
    }
}
