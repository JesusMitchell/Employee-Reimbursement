package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil cu = null;
    private static Properties dbProps;

    private ConnectionUtil(){
        dbProps = new Properties();
        InputStream props = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");

        try{
            dbProps.load(props);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static synchronized ConnectionUtil getConnectionUtil() {

        if (cu == null) {

            cu = new ConnectionUtil();
        }
        return cu;
    }

    public Connection getConnection(){
        Connection conn = null;

        try {
            Class.forName(dbProps.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url= dbProps.getProperty("url");
        String username = dbProps.getProperty("username");
        String password = dbProps.getProperty("password");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }
    public static void main(String[] args) {
    Connection connection = getConnectionUtil().getConnection();

        try {
           if (connection != null) {
                System.out.println("Connection Successful");
                connection.close();
          }
            else {
               System.out.println("Something went wrong..");
            }
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }




}
