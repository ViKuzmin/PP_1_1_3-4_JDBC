package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("1", "Aaasd", (byte) 15);
        userService.saveUser("2", "Bbbb", (byte) 15);
        userService.saveUser("3", "Ggggg", (byte) 15);
        userService.saveUser("4", "Ssss", (byte) 15);

        userService.removeUserById(3);
        //userService.dropUsersTable();
        userService.createUsersTable();
        System.out.println(userService.getAllUsers());
        //userService.cleanUsersTable();
        //userService.dropUsersTable();
    }
}
