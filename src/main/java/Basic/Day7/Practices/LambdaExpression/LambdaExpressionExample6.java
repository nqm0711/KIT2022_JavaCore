package Basic.Day7.Practices.LambdaExpression;

interface Divide {
    int divide(int dividend, int divisor);
}

public class LambdaExpressionExample6 {
    public static void main(String[] args) {
        Divide dv1 = (a, b) -> (a/b); // Lambda expression without return keyword. // { return (a+b); }
        System.out.println(dv1.divide(20, 2));
        Divide dv2 = (int a, int b) -> { // Lambda expression with return keyword.
            return (a/b);
        };
        System.out.println(dv2.divide(100, 4));
    }
}

//interface Addable {
//    int add(int a, int b);
//}
//
//public class LambdaExpressionExample6 {
//    public static void main(String[] args) {
//        Addable ad1 = (a, b) -> (a + b); // Lambda expression without return keyword. // { return (a+b); }
//        System.out.println(ad1.add(10, 20));
//        Addable ad2 = (int a, int b) -> { // Lambda expression with return keyword.
//            return (a + b);
//        };
//        System.out.println(ad2.add(100, 200));
//    }
//}