package Basic.Day1;

public class Dang2 {

    public static void main(String[] args) {
//        (1) Cho mảng int [] A={5, 1, 9, 10, 16, 4, 6, 8, 3}. // Hãy xác định và in dãy con tăng dần dài nhất //

        System.out.println('\n'+"\n" + "BÀI TẬP 1 :"+"\n");
        int [] A1 = {5, 1, 9, 10, 16, 4, 6, 8, 3};
        int max1=1;
        int count1=1;
        int lastIndex1=0;
        int [] B1 = new int[1];
        for (int i=1;i<A1.length;i++) {
            if (A1[i]>A1[i-1]) count1++;
            else  count1=1;
            if (count1>max1) { max1=count1; lastIndex1=i; }
        }
        System.out.println("1.1: Số phần tử của dãy dài nhất là "+max1);
        System.out.print("1.2: Dãy dài nhất là");
        for (int i = lastIndex1+1-max1; i<lastIndex1+1; i++) {System.out.print(" "+A1[i]);}

//        (2) Cho mảng int [] A={5, 1, 9, 10,16, 4,6, 8, 3}. // Hãy xác định và in dãy con tăng dần dài nhất có tổng các phần tử lớn hơn 20 //
        System.out.println('\n'+"\n" + "BÀI TẬP 2 :"+"\n");
        int [] A2 = {5, 1, 9, 10,16, 4,6, 8, 3};
        int max2=1;
        int count2=1;
        int lastIndex2=0;
        int tong= A2[0];
        int [] B2 = new int[1];
        for (int i=1;i<A2.length;i++) {
            if (A2[i]>A2[i-1]) {count2++; tong+=A2[i];}
            else  {count2=1;tong=A2[i];}
            if (tong>20&&count2>max2) { max2=count2; lastIndex2=i;}
        }
        System.out.println("2.1: Số phần tử của dãy dài nhất có tổng các phần tử lớn hơn 20 là "+max2);
        System.out.print("2.2: Dãy đó là");
        for (int i = lastIndex2+1-max2; i<lastIndex2+1; i++) {System.out.print(" "+A2[i]);}


//        (3) Cho mảng int [] A={5, 1, 9, 10,16, 4,6, 8, 3}. // Hãy xác định và in dãy con có các số chẵn liên tiếp dài nhất
        System.out.println('\n'+"\n" + "BÀI TẬP 3 :"+"\n");
        int [] A3 = {5, 1, 9, 10,16, 4,6, 8, 3};
        int max3=0;
        int count3=1;
        int lastIndex3=0;
        int [] B3 = new int[1];
        for (int i=1;i<A3.length;i++) {
            if (A3[i-1]%2==0&&A3[i]%2==0) count3++;
            else  count3=1;
            if (count3>max3) { max3=count3; lastIndex3=i;}
        }
        System.out.println("3.1: Số phần tử của dãy có các số chẵn liên tiếp dài nhất là "+max3);
        System.out.print("3.2: Dãy đó là");
        for (int i = lastIndex3+1-max3; i<lastIndex3+1; i++) {System.out.print(" "+A3[i]);}
    }
}
