package Basic.Day2.Sort;

public class BubbleSort {
    static void swap(int[] X, int a, int b) {
        int temp = X[a];
        X[a] = X[b];
        X[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println('\n' + "\n" + "BÀI TẬP 3 :");
        System.out.println("\n");
        System.out.println('\n' + "VERSION 1 = 2 for:" + "\n");
        int[] A = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j > i; j--) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                }
            }
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int value : A) {
            System.out.print(value + " ");
        }
        /////////////////////////////////////////////////////////////////////////////
        System.out.println("\n");
        System.out.println('\n' + "VERSION 1 = 2 while:" + "\n");
        A = new int[]{19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int i = 0;
        while (i < A.length) {
            int j = A.length - 1;
            while (j > i) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                }
                j--;
            }
            i++;
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int value : A) {
            System.out.print(value + " ");
        }
        /////////////////////////////////////////////////////////////////////////////
        System.out.println("\n");
        System.out.println('\n' + "VERSION 2 = 2 for:" + "\n");
        A = new int[]{19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        for (int k = A.length-1; k >= 0; k--) {
            for (int j = 0; j < k; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int value : A) {
            System.out.print(value + " ");
        }
        /////////////////////////////////////////////////////////////////////////////
        System.out.println("\n");
        System.out.println('\n' + "VERSION 2 = 2 while:" + "\n");
        A = new int[]{19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int k =A.length-1;
        while (k >= 0) {
            int j = 0;
            while (j < k) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
                j++;
            }
            k--;
        }
        System.out.print("Mảng đã sắp xếp: ");
        for (int value : A) {
            System.out.print(value + " ");
        }
        /////////////////////////////////////////////////////////////////////////////
    }
}
