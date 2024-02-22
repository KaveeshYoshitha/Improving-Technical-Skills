package connectDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectionClass {
    public static void main(String[] args) {
        try {
            //step1 load the driver class
            //class.forName.forName("com.mysql.jdbc.");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            //step2 create  the connection object with the connection string
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nibm","root","@Vengeance4444");

            //step3 create the statement object
            Statement stmt = con.createStatement();


            //step4 execute query
            ResultSet rs = stmt.executeQuery("select * from Student WHERE age='20'");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            //step5 close the connection object
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
