package utils;

import org.junit.BeforeClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ConnectingDatabase {
    public static Statement stmt;
    public static Connection conn;

    public static String connectDB(String userName) throws SQLException {
        String password = null;
        ResultSet rs = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("Select Password from userInfo where UserName='" + userName + "'");//query to fetch password from system

            while (rs.next()) {
                password = rs.getString("Password");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error in Database Driver");
            return "failed";
        } catch (SQLException e) {
            System.out.println("Issue in SQL Query");
            return "Failed";
        } finally {
            conn.close();
            stmt.close();
        }

        if (password != null)
            return password;
        else
            return null;
    }


}





