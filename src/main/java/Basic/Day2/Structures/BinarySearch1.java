package Basic.Day2.Structures;

public class BinarySearch1 {
    public static int BinarySearch(int [] A,int searchValue){
        int left = 0;
        int right = A.length-1;
        int mid = 0;
        while (right>=left) {
            mid = (right+left)/2;
            if (searchValue==A[mid]){return mid;}
            else if (searchValue<A[mid]){right = mid;}
            else if (searchValue>A[mid]){left = mid;}
        }
        return mid;
    }
}
