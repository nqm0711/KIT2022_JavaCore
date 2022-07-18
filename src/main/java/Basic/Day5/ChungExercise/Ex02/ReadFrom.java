package BTVN05.Ex02;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ReadFrom {
    public static void main(String[] args) throws IOException {
        String outputFile = "BTVN05\\Ex02\\FileStudents.dat";
        ObjectOutputStream objectOutput = null;
        FileReader fr = new FileReader("BTVN05\\Ex02\\filetext.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream(outputFile));
            Student studenA = new Student();
            String[] integersInString = br.readLine().split(",");
            // for (int i = 0; i < integersInString.length; i++) {

            // System.out.println(integersInString[i]);

            // }
            String hoten = integersInString[0];
            studenA.setHoten(hoten);

            String quequan = integersInString[1];
            studenA.setQuequan(quequan);

            int namsinh = Integer.parseInt(integersInString[2]);
            studenA.setNamsinh(namsinh);

            float diemTB = Float.parseFloat(integersInString[3]);
            studenA.setDiemTB(diemTB);

            System.out.println("Ten : " + studenA.getHoten());
            System.out.println("Que Quan : " + studenA.getQuequan());
            System.out.println("NamSinh : " + studenA.getNamsinh());
            System.out.println("Diem : " + studenA.getDiemTB());
            objectOutput.writeObject(studenA);
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
