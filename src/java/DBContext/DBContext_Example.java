package Context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext_Example {

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
 /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName;//+"; integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
//        return DriverManager.getConnection(url);
    }

    /*Insert your other code right after this comment*/
 /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "se1623JS-Gr6-SWP391";
    private final String portNumber = "2808";
    private final String userID = "sa";
    private final String password = "samsunggears3";
}

class Using {

    public static void main(String[] args) {
        try {
            new DBContext_Example().getConnection();
            System.out.println("Connection successful");
        } catch (Exception e) {
            System.out.println("Connection failed " + e.getMessage());
        }
    }
}
