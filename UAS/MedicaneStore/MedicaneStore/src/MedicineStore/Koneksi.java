package MedicineStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static final String Url = "jdbc:mysql://localhost/dbobat";
    private static final String Username = "root";
    private static final String Password = "";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(Url, Username, Password);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println((char)27 +  "[01;31m \nError : Gagal terkoneksi ke Database " + e.getMessage() + (char)27 + "[00;00m");
            }
        }
        return connection;
    }
}

