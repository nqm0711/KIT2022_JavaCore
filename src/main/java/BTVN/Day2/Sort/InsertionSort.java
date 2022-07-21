package BTVN.Day2.Sort;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println('\n' + "\n" + "BÀI TẬP 2 : INSERTION SORT" + "\n");
        System.out.println('\n' + "Version 1 = 2 for:" + "\n");
        int[] A = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int temp = 0;
        for (int i = 1; i < A.length; i++) {
            temp = A[i];
            int j = i - 1;
            for (; j >= 0 && A[j] > temp; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = temp;
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int i : A) {
            System.out.print(i + " ");
        }
        /////////////////////////////////////////////////////////////////////////////
        System.out.println('\n');
        System.out.println('\n' + "Version 2 = 2 for:" + "\n");
        A = new int[]{19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        for (int i = A.length - 2; i >= 0; i--) {
            temp = A[i];
            int j = i + 1;
            for (; j <= A.length - 1 && A[j] < temp; j++) {
                A[j - 1] = A[j];
            }
            A[j - 1] = temp;
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int i : A) {
            System.out.print(i + " ");
        }
        /////////////////////////////////////////////////////////////////////////////
        System.out.println('\n');
        System.out.println('\n' + "Version 2 = for + while:" + "\n");
        A = new int[]{19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        for (int i = A.length - 2; i >= 0; i--) {
            temp = A[i];
            int j = i + 1;
            while (j <= A.length - 1 && A[j] < temp) {
                A[j - 1] = A[j];
                j++;
            }
            A[j - 1] = temp;
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int i : A) {
            System.out.print(i + " ");
        }
        /////////////////////////////////////////////////////////////////////////////
        System.out.println('\n');
        System.out.println('\n' + "Version 2 = 2 while:" + "\n");
        A = new int[]{19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int i = A.length-2;
        while (i >= 0) {
            temp = A[i];
            int j = i + 1;
            while (j <= A.length - 1 && A[j] < temp) {
                A[j - 1] = A[j];
                j++;
            }
            A[j - 1] = temp;
            i--;
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int j : A) {
            System.out.print(j + " ");
        }
    }
}