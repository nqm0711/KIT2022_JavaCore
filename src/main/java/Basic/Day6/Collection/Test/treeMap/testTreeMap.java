package Basic.Day6.Collection.Test.treeMap;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author ManhHung
 */
public class testTreeMap {
    static class compareEmployee implements Comparator<Employee2> {

    public int compare(Employee2 a, Employee2 b) {
        return a.getJoinDate().compareTo(b.getJoinDate());
    }
}
    public static <age> void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Sap xep theo nhu khi xay dung lop Student (theo code)
    Map<Employee2,Number> employees = new TreeMap<>(); // Employee2 -> Diem TB
        //FirstName, LastName,joinDate, Age
        employees.put(new Employee2("Thế","Đoàn", dateFormat.parse("2022-07-19")),20);
        employees.put(new Employee2("Chung","Đỗ", dateFormat.parse("2022-07-20")),25);
        employees.put(new Employee2("Hải","Nguyễn", dateFormat.parse("2022-07-18")),30);
        System.out.println("Sorted by FirstName" + employees);

        Employee2 em1 = new Employee2("Chung","Đỗ", dateFormat.parse("2022-07-20")); //FirstName, LastName,joinDate, Age
                boolean kt = employees.containsKey(em1);//
                if (kt) {
                System.out.println("Found key");
                } else {
                System.out.println("Not Found key");
                }
//         Tìm kiếm tuổi theo nhân viên
                Employee2 em_ = new Employee2("Chung","Đỗ", dateFormat.parse("2022-07-20"));
                Number age = employees.get(em_);
                if (age != null) {
                System.out.println(age);
                }
        // Thay doi cach so sanh
        SortedMap<Employee2,Number> sortJoinDate; // sap xep lai theo join date
        sortJoinDate = new TreeMap<Employee2,Number>(new compareEmployee());
        sortJoinDate.putAll(employees);

        //  System.out.println("Sorted by score:" + sortJoinDate);
        System.out.println("====================");
        // Bo sung contains theo age
        kt = sortJoinDate.containsKey(em1);// tim kiem tren cay
        if (kt) {
        System.out.println("Found key");
        } else {
        System.out.println("Not Found key");
        }
    }
}

//static class compareStudent implements Comparator<Student> {
//
//    public int compare(Student a, Student b) {
//        return a.getName().compareTo(b.getName());
//    }
//}
//
//    // Sap xep theo nhu khi xay dung lop Student (theo code)
//    Map<Student, Double> stu = new TreeMap<>(); // Student -> Diem TB
////code, name, score
//        stu.put(new Student("A06338", "AB"), 7.5);
//                stu.put(new Student("A05726-1", "AA"), 8.6);
//                stu.put(new Student("A05379", "AC"), 6.5);
//                stu.put(new Student("A05726-2", "AD"), 6.5);
//                // System.out.println("Sorted by code" + stu);
//
//                Student st_key1 = new Student("A06338", "AA"); // code, name, score
//                boolean kt = stu.containsKey(st_key1);//
//                if (kt) {
//                System.out.println("Found key");
//                } else {
//                System.out.println("Not Found keye");
//                }
//                // Tìm kiếm điểm TB theo mã sinh sinh
//                Student st_ = new Student("A06338", "");
//                Double dtb = stu.get(st_);
//                if (dtb != null) {
//                System.out.println(dtb);
//                }
//
//                // Thay doi cach so sanh
//                SortedMap<Student, Double> sortByScore; // sap xep lai theo score
//        sortByScore = new TreeMap<Student, Double>(
//        new Comparator<Student>() {
//public int compare(Student a, Student b) {
//        return a.getName().compareTo(b.getName());
//        }
//        });
//        sortByScore.putAll(stu);
//
//        //  System.out.println("Sorted by score:" + sortByScore);
//        System.out.println("====================");
//        // Bo sung contains theo score
//        kt = sortByScore.containsKey(st_key1);// tim kiem tren cay
//        if (kt) {
//        System.out.println("Found key");
//        } else {
//        System.out.println("Not Found key");
//        }
//
//        st_ = new Student("", "AA");
//        dtb = sortByScore.get(st_);
//        if (dtb != null) {
//        System.out.println(dtb);
//        }
//        sortByScore.put(new Student("A05726-123", "AA"), 8.9);
//
//        for (Student st : sortByScore.keySet()) {
//        Double dtb1 = sortByScore.get(st);
//        System.out.println(st.toString() + ", " + dtb1);
//        }
//
//        }