package repository.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    public static Connection connection;
    private static String jdbcURL = "jdbc:mysql://localhost:3306/furamaresort";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "261020";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

