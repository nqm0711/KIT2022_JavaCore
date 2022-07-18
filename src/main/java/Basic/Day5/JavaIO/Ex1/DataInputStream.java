package Basic.Day5.JavaIO.Ex1;
import java.io.*;
import java.util.Arrays;

public class DataInputStream {
    public static void main(String[] args) {
        String input = "";
        String [] inputArray;
        int[] numberArray = new int[0];
        try {
            java.io.DataInputStream in = new java.io.DataInputStream(new FileInputStream("Numbers.dat"));
            while (in.available()>0) {
                input += in.readInt()+" ";
            }
            inputArray = input.split(" ");
            numberArray = new int [inputArray.length];
            for (int i = 0; i < inputArray.length; i++){
                numberArray[i] = Integer.parseInt(inputArray[i]);
            }
            inDayChanDaiNhat(numberArray);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void inDayChanDaiNhat(int []A){
        int max=0;
        int count=1;
        int lastIndex=0;
        for (int i=1;i<A.length;i++) {
            if (A[i-1]%2==0&&A[i]%2==0) count++;
            else  count=1;
            if (count>max) { max=count; lastIndex=i;}
        }
        System.out.print("Dãy chẵn dài nhất là: ");
        for (int i = lastIndex+1-max; i<lastIndex+1; i++) {System.out.print(" "+A[i]);}
    }

    static void addIntToArray(int [] A,int a) {
            A = new int[A.length + 1];
            A[A.length-1] = a;
    }
}
