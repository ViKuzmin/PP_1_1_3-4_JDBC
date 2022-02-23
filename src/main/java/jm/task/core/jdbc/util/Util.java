package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "***";

    public static Connection getMySQLConnection() {
        String hostName = "localhost";
        String dbName = "user";
        String userName = "root";
        String password = "***";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) {

        //Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = String.format("jdbc:mysql://%s:3306/%s", hostName, dbName);

        try {
            return DriverManager.getConnection(connectionURL, userName,
                    password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
