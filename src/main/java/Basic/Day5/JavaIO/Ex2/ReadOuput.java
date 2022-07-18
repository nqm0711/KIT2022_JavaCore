package Basic.Day5.JavaIO.Ex2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadOuput {
    public static void main(String[] args) {
        String inputFile = "BTVN05\\Ex02\\FileStudents.dat";

        try {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(inputFile));
            while (true) {
                Student student = (Student) objectInput.readObject();

                System.out.print(student.getHoTen() + "\t");
                System.out.print(student.getQueQuan() + "\t");
                System.out.print(student.getNamSinh() + "\t");
                System.out.println(student.getDiemTB());
            }
        } catch (EOFException eof) {
            System.out.println("Reached end of file");
        } catch (IOException e) {
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
