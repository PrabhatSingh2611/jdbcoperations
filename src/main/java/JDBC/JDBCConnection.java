package JDBC;
import java.sql.*;

public class JDBCConnection {
    static final String url = "jdbc:postgresql://localhost:5432/University";
    static final String username = "postgres";
    static final String pwd = "postgres";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(url,username,pwd)) {

            if (con != null) {
                System.out.println("Database got connected to the server!");
            } else {
                System.out.println("Failed to get connect to the server");
            }

        } //catch (SQLException e) {
            //System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
         catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        try (Connection con1 = DriverManager.getConnection(url,username,pwd)) {

            if (con1 != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            return con1;
        } //catch (SQLException e) {
            //System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
         catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


