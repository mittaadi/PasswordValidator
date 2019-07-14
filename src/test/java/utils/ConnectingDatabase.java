package utils;

import org.junit.BeforeClass;

import java.sql.*;
import java.util.ArrayList;

public class ConnectingDatabase {
    public static Statement stat;
    public static Connection conn;

    public static String connectDB(){
   try{
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test");
             stat = conn.createStatement();
            stat.execute("");//query to fetch password from system

        }
        catch(ClassNotFoundException e){
            System.out.println("Error in Database Driver");
            return "failed";
        }
        catch (SQLException e) {
           System.out.println("Issue in SQL Query");
            return "Failed";
        }

        return "Pass";
    }



}





