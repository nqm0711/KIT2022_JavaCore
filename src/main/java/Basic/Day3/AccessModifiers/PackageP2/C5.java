package Basic.Day3.AccessModifiers.PackageP2;
import Basic.Day3.AccessModifiers.PackageP1.C1;

public class C5 {
public static void main(String[] args){
    C1 o = new C1();
    System.out.println("Có thể truy cập "+o.x);
    System.out.println("Không thể truy cập "+"o.y");
    System.out.println("Không thể truy cập "+"o.z");
    System.out.println("Không thể truy cập "+ "o.u");
    System.out.println("Không thể truy cập "+ "o.m()");;
}
}
