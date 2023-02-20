package messangerdesignproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    public static Connection getConnection()throws Exception{

        String server = "jdbc:mysql://";
        String host = "localhost/";
        String database = "mesenger";
        
        String serverUrl = server + host + database;
        
        String userName = "root";
        String password = "";
        
        Connection myConn = DriverManager.getConnection(serverUrl, userName, password);
        
        return myConn;
    }
}
