package BTVN.Day5.JavaIO.Ex1;

import java.io.*;

public class DataOutputStream {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        try {
            FileReader inputFile = new FileReader("text.txt");
            java.io.DataOutputStream out = new java.io.DataOutputStream(new FileOutputStream("Numbers.dat"));
            BufferedReader br = new BufferedReader(inputFile);
            String[] input = br.readLine().split("\s");
            int[] numberArray = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                numberArray[i] = Integer.parseInt(input[i]);
            }
            InsertionSort(numberArray);
            for (int i : numberArray) {
                out.writeInt(i);
            }
            br.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void InsertionSort(int[] A) {
        int temp = 0;
        for (int i = 1; i < A.length; i++) {
            temp = A[i];
            int j = i - 1;
            for (; j >= 0 && A[j] > temp; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = temp;
        }
    }
}
