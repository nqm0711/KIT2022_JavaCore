package Basic.Day8.StockExchange.WorkWithDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkWithDatabase {
    public static void InsertStock(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=StockExchange;" +
                "user=sa;password=sa;encrypt=true;trustServerCertificate=true";
        // Declare the JDBC objects.
        Connection conn = null;
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// buoc 1
            conn = DriverManager.getConnection(connectionUrl); // buoc 2

            String sql = "INSERT INTO Stock ([Stock ID],[Stock Name])"
                    + " VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "FPT");
            statement.setString(2, "FPT");
            statement.executeUpdate();

            statement.setString(1, "VNPT");
            statement.setString(2, "VNPT");
            statement.executeUpdate();

            statement.setString(1, "VIN");
            statement.setString(2, "VIN");
            statement.executeUpdate();

            statement.setString(1, "SSB");
            statement.setString(2, "SSB");
            statement.executeUpdate();

            statement.setString(1, "SHB");
            statement.setString(2, "SHB");
            statement.executeUpdate();

            statement.setString(1, "EIB");
            statement.setString(2, "EIB");
            statement.executeUpdate();

            statement.setString(1, "MSB");
            statement.setString(2, "MSB");
            statement.executeUpdate();

            statement.setString(1, "OCB");
            statement.setString(2, "OCB");
            statement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
