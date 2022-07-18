package Basic.Day4.Exceptions.ExceptionsEx;

public class StudentManager{
    private StudentDAO dao;
    public StudentManager(StudentDAO dao){
        this.dao = dao;
    }
    public void findStudent(String keyword) throws StudentException {
        try {
            dao.list();
        } catch (DAOException ex) {
            throw new StudentException("Error finding students",ex);
        }
    }
}
