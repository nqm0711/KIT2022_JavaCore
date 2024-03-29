package Basic.Day7.Practices.StreamAPI.StudentStreamExample;

import java.util.*;
import java.util.stream.Collectors;


public class StudentExample {
    public static void main(String[] args) {
        List<Student> listStudents = new ArrayList<>();
        listStudents.add(new Student("Alice",82));
        listStudents.add(new Student("Bob",90));
        listStudents.add(new Student("Carol",67));
        listStudents.add(new Student("David",80));
        listStudents.add(new Student("Erich",55));
        listStudents.add(new Student("Frank",49));
        listStudents.add(new Student("Gary",88 ));
        listStudents.add(new Student("Henry",98));
        listStudents.add(new Student("Ivan",66));
        listStudents.add(new Student("John",52));

        //find students whose score >=70
        List<Student> listGoodStudents = listStudents.stream().filter(s -> s.getScore()>=70).collect(Collectors.toList());

        listGoodStudents.stream().forEach(System.out::println);

        // calculate average score for all students

        double average = listStudents.stream().mapToInt(s -> s.getScore()).average().getAsDouble();
        System.out.println("Average Score: " + average);

    }
}
