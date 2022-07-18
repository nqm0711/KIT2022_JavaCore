package Basic.Day1;

import java.util.Scanner;

public class KiemtraSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = scanner.nextInt();
//        int n = 9981;
        boolean IsPrime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                IsPrime = false;
                break;
            }
        }
        if (IsPrime) {
            System.out.println(n + " là số nguyên tố");
        } else System.out.println(n + " ko là số nguyên tố");
    }
}
