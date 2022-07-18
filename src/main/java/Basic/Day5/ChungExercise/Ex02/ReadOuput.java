package BTVN05.Ex02;

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

                System.out.print(student.getHoten() + "\t");
                System.out.print(student.getQuequan() + "\t");
                System.out.print(student.getNamsinh() + "\t");
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
