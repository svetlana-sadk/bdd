package persistence;

import java.sql.*;

public class ConnectionBD {
    private static String url = "jdbc:mysql://localhost:3306/testdb";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "";
    private static Connection myConn;

    public static Connection getConnection(){
        try{
            Class.forName(driverName); // charger le driver
            try{
                myConn = DriverManager.getConnection(url, username, password);
            } catch(SQLException ex){
                System.out.println("Failed to create a database connection.");
            }
        } catch(ClassNotFoundException e) {
            System.out.println("Driver is not found.");
        }
        return myConn;
    }

}
