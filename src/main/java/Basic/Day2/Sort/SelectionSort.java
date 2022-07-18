package Basic.Day2.Sort;

public class SelectionSort {
    static void swap(int[] Z, int a, int b) {
        int temp = Z[a];
        Z[a] = Z[b];
        Z[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println('\n' + "\n" + "BÀI TẬP 1 : SELECTION SORT" + "\n");
        System.out.println('\n' + "Từ trái qua phải :" + "\n");

        int[] A = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int min = 0;
        for (int i = 0; i < A.length - 1; i++) {
            min = i;
            for (int j = i+1; j <= A.length - 1; j++) {
                if (A[j] < A[min]) min=j;
            }
            swap(A,min,i);
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("\n"+"\n");
        System.out.println("Version 2: "+'\n'+'\n' + "Từ phải qua trái :" + "\n");
        int[] B = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int max = 0;
        for (int i = B.length -1; i >= 0; i--) {
            max = i;
            for (int j = i-1; j >= 0; j--) {
                if (B[j] > B[max]) max=j;
            }
            swap(B,max,i);
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }
}
