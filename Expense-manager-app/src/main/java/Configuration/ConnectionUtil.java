package Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/manager_app";
            String userName="root";
            String password = "Pass@1234";
            connection = DriverManager.getConnection(url,userName,password);

        }catch (ClassNotFoundException e){
            System.out.println("issue for class loading");

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
