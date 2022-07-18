package Basic.Day3.AccessModifiers.PackageP2;

import Basic.Day3.AccessModifiers.PackageP1.C1;

public class C4 extends C1 {
    public static void main(String[] args){
        C4 o = new C4();
        System.out.println("Có thể truy cập "+o.x);
        System.out.println("Có thể truy cập "+o.y);
        System.out.println("Không thể truy cập "+"o.z");
        System.out.println("Không thể truy cập "+ "o.u");
        o.m();
    }

}
