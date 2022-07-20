package Basic.Day7.Practices.LambdaExpression;

interface Greeting {
    String Hello(String hello);
}

public class LambdaExpressionExample4 {
    public static void main(String[] args) {
        Greeting g1 = (Greeting) -> { // Lambda expression with single parameter.
            return Greeting;
        };
        System.out.println(g1.Hello("Nice to meet you!"));
        Greeting g2 = Greeting -> { // You can omit function parentheses
            return Greeting;
        };
        System.out.println(g2.Hello("Annyong Haseyo !!"));
    }
}
//interface Sayable {
//    String say(String name);
//}
//public class LambdaExpressionExample4 {
//    public static void main(String[] args) {
//        Sayable s1 = (hoten) -> { // Lambda expression with single parameter.
//            return "Hello, " + hoten;
//        };
//        System.out.println(s1.say("Sonoo"));
//        Sayable s2 = name -> { // You can omit function parentheses
//            return "Hello, " + name;
//        };
//        System.out.println(s2.say("Sonoo"));
//    }
//}
