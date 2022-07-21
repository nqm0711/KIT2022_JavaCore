package BTVN.Day6.Solution;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class Element {

    int id, amount;

    Element(String id, String amount) {
        this.id = Integer.parseInt(id.trim());
        this.amount = Integer.parseInt(amount.trim());
    }
}

class MinMax {
    private int min;
    private int max;
    MinMax(int m) {
        min = max = m;
    }
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
public class Exercise2_Collection_IO {

    public static void main(String[] args) {
        Map<Integer, MinMax> hm= new HashMap<>();
        try {
            readFromFile("capso.txt",hm);
            writeToFile("output.txt",hm);
        } catch (IOException ex) {
            Logger.getLogger(Exercise2_Collection_IO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void readFromFile(String fName, Map<Integer,MinMax> hm) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fName));
        String st = br.readLine();
        while (st != null) {
            // xử lý
            st = st.replace(".", "");
            String[] arr = st.split(";"); //id: amount;
            for (int i = 0; i < arr.length; i++) {
                String[] id_amount = arr[i].split(":");
                Element el = new Element(id_amount[0], id_amount[1]);
                MinMax mm=hm.get(el.id);
                if (mm==null)
                    hm.put(el.id, new MinMax(el.amount));
                else {
                    if (el.amount<mm.getMin()) mm.setMin(el.amount);
                    if (el.amount>mm.getMax()) mm.setMax(el.amount);
                }
            }
            st = br.readLine();
        }
    }

    static void writeToFile(String fName, Map<Integer,MinMax> hm) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fName));
        try {
            bw.write(Integer.toString(hm.size()));
            bw.newLine();
            for (Map.Entry<Integer, MinMax> sanPham : hm.entrySet()) {
                bw.write(sanPham.getKey() + ":" + sanPham.getValue().getMin() + ", " + sanPham.getValue().getMax()+".");
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}