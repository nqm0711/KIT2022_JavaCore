package Basic.Day4.Exceptions.ExceptionsEx;

public class StudentProgram {
    public static void main(String[] agrs){
        StudentDAO dao = new StudentDAO();
        StudentManager manager = new StudentManager(dao);
        try {
            manager.findStudent("Tom");
        } catch (StudentException ex) {
            ex.printStackTrace();
        }
    }
}
