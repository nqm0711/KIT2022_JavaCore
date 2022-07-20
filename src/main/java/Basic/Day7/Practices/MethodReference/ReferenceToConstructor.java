package Basic.Day7.Practices.MethodReference;

interface Introduce { void introduce (String name,int age, String city); }

class Person {

    public Person( String name,int age, String city) {
        System.out.println("Hello my name is "+name+", I am "+age+" and I'm living in "+city);
    }
}


public class ReferenceToConstructor {
    public static void main(String[] args) {
        Introduce intro = Person::new;
        intro.introduce("Thế",24,"Hà Nội");
    }
}


//interface Messageable { Message getMessage (String msg); }
//class Message {
//    Message () {}
//    Message (String msg) { System.out.print(msg); }
//}
//public class ReferenceToConstructor {
//    public static void main(String[] args) {
//        Messageable hello = Message::new;
//        hello.getMessage("Hello");
//    }
//}