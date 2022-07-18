package Basic.Day3.Inheritance;

public class Sphere {
    public static void main(String[] args) {
        Sphere1 sp= new Sphere1();
        System.out.println("Hello");
    }
}
class Sphere1 extends SuperCircle {
    protected String name;
    int x;

    public Sphere1() {
        super(100);
        name = "Sphere";
    }
}
