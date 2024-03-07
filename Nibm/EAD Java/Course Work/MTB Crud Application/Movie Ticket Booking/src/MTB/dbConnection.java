package MTB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbConnection {
    private Connection connection;
    public Statement statement;

    public dbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC driver
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/cinema", "root", "root");
            statement = connection.createStatement();
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            System.err.println("Error in database connection:");
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Error in query execution:");
            e.printStackTrace();
            return null;
        }
    }
}
