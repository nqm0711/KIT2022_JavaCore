package Basic.Day5.ChungExercise.Ex02;

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
            String hoTen = integersInString[0];
            studenA.setHoTen(hoTen);

            String queQuan = integersInString[1];
            studenA.setQueQuan(queQuan);

            int namSinh = Integer.parseInt(integersInString[2]);
            studenA.setNamSinh(namSinh);

            float diemTB = Float.parseFloat(integersInString[3]);
            studenA.setDiemTB(diemTB);

            System.out.println("Ten : " + studenA.getHoTen());
            System.out.println("Que Quan : " + studenA.getQueQuan());
            System.out.println("NamSinh : " + studenA.getNamSinh());
            System.out.println("Diem : " + studenA.getDiemTB());
            objectOutput.writeObject(studenA);
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
