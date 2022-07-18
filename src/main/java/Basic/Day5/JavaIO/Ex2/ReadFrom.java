package Basic.Day5.JavaIO.Ex2;

import java.io.*;

public class ReadFrom {
    public static void main(String[] args) throws IOException {
        String outputFile = "StudentOutput.dat";
        ObjectOutputStream objectOutput = null;
        FileReader fr = new FileReader("StudentInput.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream(outputFile));
            Student studentA = new Student();
            String[] studentStringArray = br.readLine().split(",");
            // for (int i = 0; i < studentStringArray.length; i++) {

            // System.out.println(studentStringArray[i]);

            // }
            String hoTen = studentStringArray[0];
            studentA.setHoTen(hoTen);

            String queQuan = studentStringArray[1];
            studentA.setQueQuan(queQuan);

            int namSinh = Integer.parseInt(studentStringArray[2]);
            studentA.setNamSinh(namSinh);

            float diemTB = Float.parseFloat(studentStringArray[3]);
            studentA.setDiemTB(diemTB);

            System.out.println("Ten : " + studentA.getHoTen());
            System.out.println("Que Quan : " + studentA.getQueQuan());
            System.out.println("NamSinh : " + studentA.getNamSinh());
            System.out.println("Diem : " + studentA.getDiemTB());
            objectOutput.writeObject(studentA);
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
