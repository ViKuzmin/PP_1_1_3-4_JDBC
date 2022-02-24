package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Aaa", "Aaasd", (byte) 15);
        userService.saveUser("Bbb", "Bbbb", (byte) 15);
        userService.saveUser("Gggg", "Ggggg", (byte) 15);
        userService.saveUser("ffffSsss", "Ssss", (byte) 15);

        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
