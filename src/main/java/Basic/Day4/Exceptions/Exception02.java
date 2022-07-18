package Basic.Day4.Exceptions;

public class Exception02 {
    public static void main(String[] args){
        try {
            b();
        } catch (Exception e) {
        }
    }
    static void b() throws Exception {
        float x = 0;
        try {
            System.out.println("1.1 Try...");
            x = 1 / 0;
            System.out.println("1.2 Try...");
        } catch (Exception e) {
            System.out.println("2. Exception: (chia 0)");
        } finally {
            System.out.println("3. Trong finally...");
        }
        System.out.println("4. Sau Try catch...");
    }
//    static void a() throws Exception {
//        b();
//    }
}
