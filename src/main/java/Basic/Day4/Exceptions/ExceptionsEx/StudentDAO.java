package Basic.Day4.Exceptions.ExceptionsEx;

import java.sql.SQLException;

public class StudentDAO{
    public void list() throws DAOException {
        try{
            DatabaseUtils.excecuteQuery("SELECT");
        } catch (SQLException ex) {
            throw new DAOException("Error querying students from database",ex);
        }
    }
}
