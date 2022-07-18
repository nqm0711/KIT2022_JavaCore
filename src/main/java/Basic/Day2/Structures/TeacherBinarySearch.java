package Basic.Day2.Structures;

public class TeacherBinarySearch {
    public static void main(String[] args) {
        int[] A = {4, 6, 7, 9, 12, 14, 18, 19, 20, 21};
        BSearch bs = new BSearch(A);
        int vt = bs.search(6, bs.l, bs.r);
        if (vt > -1)
            System.out.println("thay o vt: " + vt);
        else
            System.out.println("Ko thay");

//        int x = 16;
//        int l = 0, r = A.length - 1;//9
//        int vt=search(A, 6,l,r);
//        if (vt>-1)
//            System.out.println("thay o vt: "+vt);
//        else
//            System.out.println("Ko thay");
//

//        int mid;
//        while (r >= l) {
//            mid = (l + r) / 2;
//            if (x == A[mid]) {
//                System.out.println("Thay o vi tri:" + mid);
//                return;
//            }
//            if (A[mid] > x) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        System.out.println("Ko thay");
    }

//    static int search(int[] A, int x, int l, int r) {
//        if (r < l) {
//            return -1;
//        }
//        int mid = (l + r) / 2;
//        if (A[mid] == x) {
//            return mid;
//        }
//        if (A[mid] > x) {
//            return search(A, x, l, mid - 1);
//        }
//        return search(A, x, mid + 1, r);
//    }
}

class BSearch {
    int[] A;
    int l, r;

    BSearch(int[] B) {
        A = new int[B.length];
        for (int i = 0; i < B.length; i++)
            A[i] = B[i];
        l = 0;
        r = A.length - 1;
    }

    int search(int x, int l, int r) {
        if (r < l) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (A[mid] == x) {
            return mid;
        }
        if (A[mid] > x) {
            return this.search(x, l, mid - 1);
        }
        return this.search(x, mid + 1, r);
    }
}
