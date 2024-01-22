import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] agrs ){
        //Database URL
        String url = "jdbc:mysql://localhost:3306/Students";

        //Database credentials
        String username = "root";
        String password = "Vinita@123";

        //Establish the connection
        try(Connection connection = DriverManager.getConnection(url,username , password)){
            System.out.println("Connected to the database ");
            System.out.println(connection);
        }
        catch(SQLException e ){
          System.err.println("connection failed : " + e.getMessage());
        }
    }
}


