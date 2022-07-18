package Basic.Day4.Exceptions.ExceptionsEx;

import java.sql.SQLException;

public class DatabaseUtils{
    public static void excecuteQuery(String sql) throws SQLException {
        throw new SQLException("Syntax error");
    }
}
