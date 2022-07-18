package Basic.Day4.Exceptions.ExceptionsEx;
import java.sql.*;
public class DAOException extends Exception{
    public DAOException(String message, Throwable cause){
        super(message, cause);
    }
}
