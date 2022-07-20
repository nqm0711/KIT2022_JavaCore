package Basic.Day7.Practices.StreamAPI.StreamMethod;

import java.util.*;

public class StreamFunctions {
    public static void main(String[] args) {
        List <Person> listPersons = new ArrayList<>();
        listPersons.add(new Person("Bob","Young","bob@gmail.com",Gender.MALE,32));
        listPersons.add(new Person("Carol","Hill","carol@gmail.com",Gender.FEMALE,23));
        listPersons.add(new Person("Carol","Hill","carol@gmail.com",Gender.FEMALE,23));

//                            filter()

        listPersons.stream().filter(p->p.getGender().equals(Gender.MALE)).forEach(System.out::println);
        listPersons.stream().filter(p->p.getGender().equals(Gender.FEMALE)).forEach(System.out::println);

//                            map()

//        listPersons.stream().map(Person::getEmail).forEach(System.out::println);
//        listPersons.stream().map(Person::getAge).forEach(age -> System.out.print (age+ " - "));
        listPersons.stream().map(p->p.getEmail()).forEach(System.out::println);
        listPersons.stream().map(p->p.getAge()).forEach(age -> System.out.print (age+ " - "));
        listPersons.stream().map(p->p.getFirstName().toUpperCase()).forEach(System.out::println);

//                            sort()

        listPersons.stream().sorted().forEach(p -> System.out.println(p + " - "+ p.getAge()));

//                            sort() use comparator

        listPersons.stream().sorted((p1,p2)->p1.getLastName().compareTo(p2.getLastName())).forEach(System.out::println);

//                            limit()

        listPersons.stream().sorted().limit(5).forEach(System.out::println);

//                            skip()

        System.out.print("The oldest age: ");
//        listPersons.stream().sorted().map(Person::getAge).skip(listPersons.size()-1).forEach(System.out::println);
        listPersons.stream().sorted().map(p->p.getAge()).skip(listPersons.size()-1).forEach(System.out::println);

//                            allMatch()

        boolean areAllMale = listPersons.stream().allMatch(p -> p.getGender().equals(Gender.MALE));
        System.out.println("Are all person male? "+ areAllMale);

//                            distinct()
        listPersons.stream().distinct().forEach(i-> System.out.print(i +" "));

    }
}