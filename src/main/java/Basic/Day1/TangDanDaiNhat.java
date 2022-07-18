package Basic.Day1;
import java.util.Arrays;

public class TangDanDaiNhat {
    public static void main(String[] args) {
        int[] A = {5, 7, 1, 9, 10, 16, 4, 6, 8, 3};
        int[] B = {A[0]};
        int [] C= new int[1];
        int soPhanTu = 0;
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= B[B.length-1]) {
                B= Arrays.copyOf(B,B.length+1);
                B[B.length-1]=A[i];
            } else {
                soPhanTu = B.length;
                B=new int[1];
                B[0]=A[i];
            }
            if (max < soPhanTu) {max = soPhanTu;C = Arrays.copyOfRange(A,i-max,i);};
        }
        System.out.println("Dãy dài nhất có " + max + " phần tử");
        System.out.println("Dãy dài nhất là" + Arrays.toString(C));
    }
}
