package Basic.Day1;

public class Dang3 {
    public static void main(String[] args) {
//        BÀI TẬP VÍ DỤ
        System.out.println('\n'+"\n" +"Bài tập ví dụ"+"\n");
        int[] A0 = {12, 3, 434, 12, 43, 434, 38, 55};
        int[] pos0 = new int[A0.length];
        int max0 = A0[0];
        int cnt0 = 1; // Giả thiết A[0] LN và xuất hiện 1 lần
        pos0[cnt0 - 1] = 0;
        for (int i = 1; i < A0.length; i++) {
            if (max0 == A0[i]) {
                cnt0++;
                pos0[cnt0 - 1] = i;
            } else if (max0 < A0[i]) {
                max0 = A0[i];
                cnt0 = 1;
                pos0[cnt0 - 1] = i;
            }
        }
//        Thay đổi đoạn in kết quả theo yêu cầu sau:
//         (1) Nếu chỉ xuất hiện 1 lần: Max = ... ở vị trí: ....
//         (2) Nếu xuất hiện nhiều lần:
//         Max = ... Số lần: ....
//          Ở các vị trí: 3, 5, 6, ...10.

        if (cnt0 == 1) {
            System.out.println("Max = " + max0 + " ở vị trí: " + (pos0[cnt0 - 1] + 1));
        } else {
            System.out.print("Max = " + max0 + " Số lần: " + cnt0 + '\n' + "Ở các vị trí: ");
            for (int i = 0; i < cnt0; i++) System.out.print(pos0[i] + 1 + " ");
        }


//        Bài tập áp dụng:
//        (1) Cho mảng int [] A={5, 3, 7, 8, 4, 6, 8, 3}. // Hãy xác định và in tất cả các dãy con  tăng dần dài nhất cùng các vị trí bắt đầu xuất hiện của nó
        int[] A1 = {5, 3, 7, 8, 4, 6, 8, 3};
        int max1 = 1;
        int countArr1 = 1;
        int count1 = 1;
        int[] pos1 = new int[A1.length];
        pos1[countArr1 - 1] = 0;
        System.out.println('\n'+"\n" + "BÀI TẬP 1 :"+"\n");
        for (int i = 1; i < A1.length; i++) {
            if (A1[i] > A1[i - 1]) count1++;
            else count1 = 1;
            if (count1 == max1) {
                countArr1++;
                pos1[countArr1 - 1] = i + 1 - max1;
            }
            if (count1 > max1) {
                max1 = count1;
                countArr1 = 1;
                pos1[countArr1 - 1] = i + 1 - max1;
            }
        }
        if (countArr1 == 1) {
            System.out.println("Dãy dài nhất có số phần tử là " + max1 + " và bắt đầu xuất hiện ở vị trí: " + (pos1[countArr1 - 1] + 1));
            System.out.print("Dãy đó là: ");
            for (int j = pos1[countArr1 - 1]; j < pos1[countArr1 - 1] + max1; j++) {
                System.out.print(A1[j] + " ");
            }
        }
        else {
            System.out.print("Các dãy dài nhất có số phần tử là " + max1 + " và xuất hiện "+countArr1+ " lần : ");
            for (int i = 0; i < countArr1; i++) {
                System.out.print('\n' + "Dãy thứ "+(i+1)+" là: ");
                for (int j = pos1[i]; j < pos1[i] + max1; j++) {
                    System.out.print(A1[j] + " ");
                }
                System.out.print(" ở vị trí thứ "+ (pos1[i] + 1) + " ");
            }
        }
//        (2) Cho mảng int [] A={5, 1, 9, 10,16, 4,6, 8, 3}. // Hãy xác định và in tất cả các dãy con  tăng dần dài nhất có tổng các phần tử lớn hơn 100 cùng các vị trí bắt đầu xuất hiện của nó
        int[] A2 = {5, 1, 9, 10,16, 4,6, 8, 3};
        int max2 = 0;
        int countArr2 = 0;
        int count2 = 1;
        int[] pos2 = new int[A1.length];
        int tong= A2[0];
        pos2[countArr2] = 0;
        System.out.println('\n'+"\n" + "BÀI TẬP 2 :"+"\n");
        for (int i = 1; i < A2.length; i++) {
            if (A2[i] > A2[i - 1]) {count2++;tong+=A2[i];}
            else {count2 = 1;tong=A2[i];}
            if (tong>100&&count2 == max2) {
                countArr2++;
                pos2[countArr2] = i + 1 - max2;
            }
            if (tong>100&&count2 > max2) {
                max2 = count2;
                countArr2 = 0;
                pos2[countArr2] = i + 1 - max2;
            }
        }
        if (countArr2 == 0)System.out.print("Không tồn tại dãy thoải mãn điều kiện");
        else if (countArr2 == 1) {
            System.out.println("Dãy có tổng các phần tử lớn hơn 100 dài nhất có số phần tử là " + max2 + " và bắt đầu xuất hiện ở vị trí: " + (pos1[countArr2] + 1));
            System.out.print("Dãy đó là: ");
            for (int j = pos2[countArr2]; j < pos1[countArr2] + max2; j++) {
                System.out.print(A2[j] + " ");
            }
        }
        else {
            System.out.print("Các dãy có tổng các phần tử lớn hơn 100 dài nhất có số phần tử là " + max2 + " và xuất hiện "+countArr2+ " lần : ");
            for (int i = 0; i < countArr2; i++) {
                System.out.print('\n' + "Dãy thứ "+(i+1)+" là: ");
                for (int j = pos2[i]; j < pos2[i] + max2; j++) {
                    System.out.print(A2[j] + " ");
                }
                System.out.print(" ở vị trí thứ "+ (pos2[i] + 1) + " ");
            }
        }

//        (3) Cho mảng int [] A={5, 1, 9, 10,16, 4,6, 8, 3}. // Hãy xác định và in ra tất cả các dãy con dài nhất gồm các phần tử là các số chẵn.
        int[] A3 = {5, 1, 9, 10,16, 4,6, 8, 3};
        int max3 = 0;
        int countArr3 = 0;
        int count3 = 1;
        int[] pos3 = new int[A3.length];
        pos3[countArr3] = 0;
        System.out.println('\n'+"\n" + "BÀI TẬP 3 :"+"\n");
        for (int i = 1; i < A3.length; i++) {
            if (A3[i-1]%2==0&&A3[i]%2==0) count3++;
            else count3 = 1;
            if (count3 == max3) {
                countArr3++;
                pos3[countArr3] = i + 1 - max3;
            }
            if (count3 > max3) {
                max3 = count3;
                countArr3 = 1;
                pos3[countArr3] = i + 1 - max3;
            }
        }
        if (countArr3 == 0)System.out.print("Không tồn tại dãy thoải mãn điều kiện");
        else if (countArr3 == 1) {
            System.out.println("Dãy gồm các phần tử là các số chẵn dài nhất có số phần tử là " + max3 + " và bắt đầu xuất hiện ở vị trí: " + (pos3[countArr3] + 1));
            System.out.print("Dãy đó là: ");
            for (int j = pos3[countArr3]; j < pos3[countArr3] + max3; j++) {
                System.out.print(A3[j] + " ");
            }
        }
        else {
            System.out.print("Các dãy gồm các phần tử là các số chẵn dài nhất có số phần tử là " + max3 + " và xuất hiện "+countArr3+ " lần : ");
            for (int i = 0; i < countArr3; i++) {
                System.out.print('\n' + "Dãy thứ "+(i+1)+" là: ");
                for (int j = pos3[i]; j < pos3[i] + max3; j++) {
                    System.out.print(A3[j] + " ");
                }
                System.out.print(" ở vị trí thứ "+ (pos3[i] + 1) + " ");
            }
        }
    }
}