package Basic.Day5.JavaIO.Ex2;

import java.io.*;
import java.util.Arrays;

public class ObjectOutputStream {


    static void SapXepChenTheoNamSinh(Student[] A) {
        int namSinh;
        Student studentTemp1,studentTemp2;
        for (int i = 1; i < A.length; i++) {
            studentTemp1 = A[i];
            namSinh = studentTemp1.getNamSinh();
            int j = i - 1;
            studentTemp2=A[j];
            for (; j >= 0 && studentTemp2.getNamSinh() > namSinh; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = studentTemp1;
        }
    }
    public static void main(String[] args) throws IOException {
        String outputFile = "FileStudents.dat";
        java.io.ObjectOutputStream objectOutput;
        FileReader fr = new FileReader("StudentInput.txt");
        BufferedReader br = new BufferedReader(fr);
        int length = 0;
        Student[] StudentsArray = new Student[length];
        try {
            objectOutput = new java.io.ObjectOutputStream(new FileOutputStream(outputFile));
            Student student;
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String[] studentStringArray = line.split(",");
                student = new Student();
                length++;

                String hoTen = studentStringArray[0];
                student.setHoTen(hoTen);

                String queQuan = studentStringArray[1];
                student.setQueQuan(queQuan);

                int namSinh = Integer.parseInt(studentStringArray[2].trim());
                student.setNamSinh(namSinh);

                float diemTB = Float.parseFloat(studentStringArray[3]);
                student.setDiemTB(diemTB);
                StudentsArray = Arrays.copyOf(StudentsArray,length);
                StudentsArray[length-1]= student;
            }
            SapXepChenTheoNamSinh(StudentsArray);
            for (Student i:StudentsArray){
                objectOutput.writeObject(i);
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
