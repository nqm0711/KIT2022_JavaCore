package Basic.Day1;

public class Loop1 {
    public static void main(String[] args) {
//(1) Mảng int [] A={5, 7, 9, 10,16} tạo thành dãy tăng dần hay ko? ==>yes/No

        int[] A = {5, 4, 9, 10, 10};
        int test = A[0];
        boolean tangdan = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= test) {
                test = A[i];
            } else {
                tangdan = false;
                break;
            }
        }
        if (tangdan) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        ;

//(2)Mảng int [] A={5, -1, 9, -10,16} tạo thành dãy đan dấu hay ko? ==>yes/No


        int[] B = {5, -1, 9, -10, 16};
        boolean danDau = true;
        int test2 = B[0];
        for (int i = 1; i < B.length; i++) {
            if (test2 * B[i] < 0) {
                test2 = B[i];
            } else {
                danDau = false;
                break;
            }
        }
        if (danDau) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
//(3) Mảng int [] A={5, 1, 9, 10, 16} ////ktra xem có phải tất cả các phần tử của A đều là số nguyên tố hay ko?
        int [] C = {5, 1, 9, 10, 16};
        boolean soNguyenTo= true;
        for (int j = 0; j < C.length; j++) {
            for (int i = 2; i <= Math.sqrt(C[j]); i++) {
                if (C[j] % i == 0) {
                    soNguyenTo = false;
                    break;
                }
            }
        }
        if (soNguyenTo) {
            System.out.println("Dãy C toàn số nguyên tố");
        } else System.out.println("Dãy C ko phải toàn số nguyên tố");
    }
}


