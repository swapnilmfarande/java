package org.example.Util;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class ConnectionUtil {
    @Getter
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/manager_app";
            String username = "root";
            String password = "Pass@1234";
            connection = DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException o){
            System.out.println("issue while loading the class");
        }catch (SQLException e){
            System.out.println("sql exception");
        }
    }


}
