package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
        UserServiceImpl userService = new UserServiceImpl();

        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Gggg", "Ggggg", (byte) 15);
        userService.saveUser("Aaa", "Aaasd", (byte) 15);
        userService.saveUser("Aaa", "Aaasd", (byte) 15);
        userService.saveUser("Bbb", "Bbbb", (byte) 15);
        userService.saveUser("Bbb", "Bbbb", (byte) 15);
        userService.saveUser("Ssss", "Ssss", (byte) 15);
        userService.saveUser("Ssss", "Ssss", (byte) 15);
        userService.removeUserById(4);
    }
}
