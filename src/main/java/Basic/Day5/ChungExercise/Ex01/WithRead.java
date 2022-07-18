package Basic.Day5.ChungExercise.Ex01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WithRead {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("src/main/java/Basic/Day5/ChungExercise/Ex01/file-content.txt"));
            DataOutputStream out = new DataOutputStream(new FileOutputStream("Numbers.dat"));

            String[] integersInString = br.readLine().split(" ");
            int a[] = new int[integersInString.length];
            for (int i = 0; i < integersInString.length; i++) {
                a[i] = Integer.parseInt(integersInString[i]);
            }
            for (int i = 1; i < a.length; ++i) {
                int key = a[i];
                int j = i - 1;

                // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
                // đến một vị trí trước vị trí hiện tại của chúng
                while (j >= 0 && a[j] > key) {
                    a[j + 1] = a[j];
                    j = j - 1;
                }
                a[j + 1] = key;
            }
            for (int i : a) {
                System.out.print(i + " ");
                out.writeBytes(i + " ");
            }
            // Đọc file Number

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}