package Basic.Day7.Practices.MethodReference;

interface Sayable { void hello();
}
public class ReferenceToStatic {
    public static void sayHello(){
        System.out.println("Hello !!!!!!");
    }

    public static void main(String[] args) {
        Sayable sayHello = ReferenceToStatic :: sayHello; // Referring static method
// Calling interface method
        sayHello.hello();
    }
}



//interface Sayable { void say();
//}
//public class ReferenceToStatic {
//    public static void saySomething(){
//        System.out.println("Hello, this is static method.");
//    }
//    public static void main(String[] args) {
//        Sayable sayable = ReferenceToStatic :: saySomething; // Referring static method
//// Calling interface method
//        sayable.say();
//    }
//}