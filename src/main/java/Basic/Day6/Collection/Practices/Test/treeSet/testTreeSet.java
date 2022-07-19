package Basic.Day6.Collection.Practices.Test.treeSet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author ManhHung
 */
public class testTreeSet {

    static class compareEmployees implements Comparator<Employee2> {

        public int compare(Employee2 a, Employee2 b) {
            return a.getJoinDate().compareTo(b.getJoinDate());
        }
    }

   
    public static void main(String[] args) throws ParseException {
        Set<Employee2> employees = new TreeSet<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //firstName,lastName,joinDate;
        employees.add(new Employee2("Thế","Đoàn", dateFormat.parse("2022-07-19")));
        employees.add(new Employee2("Chung","Đỗ", dateFormat.parse("2022-07-20")));
        employees.add(new Employee2("Hải","Nguyễn", dateFormat.parse("2022-07-18")));

        Employee2 em1 = new Employee2("Thế","Đoàn", dateFormat.parse("2022-07-19"));
        System.out.println("Sorted by First Name" + employees);
        boolean kt = employees.contains(em1);
        if (kt) {
            System.out.println("Found by Name");
        } else {
            System.out.println("Not Found by Name");
        }
        // Thay doi cach so sanh
        SortedSet<Employee2> sortByJoinDate = new TreeSet<Employee2>(new compareEmployees()); // sap xep lai theo joinDate
        sortByJoinDate.addAll(employees);
        System.out.println("Sorted by join date:" + sortByJoinDate);
        // Bo sung contains theo joinDate
        kt = sortByJoinDate.contains(em1);// tim kiem tren cay
        if (kt) {
            System.out.println("Found by joinDate");
        } else {
            System.out.println("Not Found by joinDate");
        }
    }

}