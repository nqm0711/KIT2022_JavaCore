package Basic.Day7.Practices.LambdaExpression;

interface Drawable {
    void draw();
}

public class LambdaExpressionExample {
    public static void main(String[] args) {
        int width = 10;
        Drawable d = () -> {
            System.out.println("Drawing " + width);
        };
        d.draw();
    }
}
//public class LambdaExpressionExample {
//    public static void main(String[] args) {
//        int width = 10;
//// without lambda, Drawable implementation using anonymous class
//        Drawable d = new Drawable() {
//            public void draw() {
//                System.out.println("Drawing " + width);
//            }
//        };
//        d.draw();
//    }
//}

