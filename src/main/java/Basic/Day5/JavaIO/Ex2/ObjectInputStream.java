package Basic.Day5.JavaIO.Ex2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class ObjectInputStream {
    public static void main(String[] args) {
        String inputFile = "FileStudents.dat";

        try {
            java.io.ObjectInputStream objectInput = new java.io.ObjectInputStream(new FileInputStream(inputFile));
            while (true) {
                Student student = (Student) objectInput.readObject();

                System.out.print(student.getHoTen() + "\s" + student.getQueQuan() + "\s" + student.getNamSinh() + "\s" + student.getDiemTB()+"\n");
            }
        } catch (EOFException eof) {
            System.out.println("\n" + "End of file");
        } catch (IOException e) {
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
