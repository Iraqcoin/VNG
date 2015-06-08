package Common.Provider;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author BatHoi
 */
 public  class ConnectionProvider {

    public static String port="3306";
    public static String username="root";
    public static String pword="123456";
    public  static String dbName="qlsv";

     public  static Connection Connect() {

        try {

            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:" + port + "/";
            Properties info = new Properties();
            info.setProperty("characterEncoding", "utf8");
            info.setProperty("user", username);
            info.setProperty("password", pword);
            Connection conn = DriverManager.getConnection(url + dbName, info);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
           
            return null;
        }
    }
}
