package Basic.Day2.Sort;


public class Test_1 {
    public static void main(String[] args) {
        //        (2) Cho mảng int [] A={5, 1, 9, 10,16, 4,6, 8, 3}. // Hãy xác định và in dãy con tăng dần dài nhất có tổng các phần tử lớn hơn 20 và nhỏ hơn 100 //
        int[] A2 = {5, 1, 9, 10, 16, 4, 6, 8, 3};
        int max2 = 1;
        int count2 = 1;
        int lastIndex2 = 0;
        int tong = A2[0];
        int tong2 = 0;
        int[] B2 = new int[1];
        for (int i = 1; i < A2.length; i++) {
            if (A2[i] > A2[i - 1]) {
                count2++;
                tong = tong + A2[i];
            } else {
                count2 = 1;
                tong = A2[i];
            }
            if (tong > 20 && tong < 100 && count2 > max2) {
                max2 = count2;
                tong2 = tong;
                lastIndex2 = i;
            }
        }
        if (tong2 == 0) {
            System.out.print("Không có dãy thỏa mãn");}
        else {
            System.out.println("1) Độ dài =" + max2 + " ;Tổng =" + tong2 + "!");
            System.out.print("2) Dãy đó là");
            for (int i = (lastIndex2 + 1 - max2); i < (lastIndex2); i++) {
                System.out.print(" " + A2[i] + ",");
            }
            ;
            System.out.print(" " + A2[lastIndex2]);
            System.out.print("!");
        }
    }
}
