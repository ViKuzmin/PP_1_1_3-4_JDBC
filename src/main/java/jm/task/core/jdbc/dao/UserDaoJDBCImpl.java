package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private Connection connection;
    private PreparedStatement preparedStatement;

    {
        try {
            connection = Util.getMySQLConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            preparedStatement = connection.prepareStatement("""
                    CREATE TABLE IF NOT EXISTS `user`.`user` (
                      `id` INT NOT NULL AUTO_INCREMENT,
                      `name` TEXT NOT NULL,
                      `lastname` TEXT NOT NULL,
                      `age` INT NOT NULL,
                      PRIMARY KEY (`id`),
                      UNIQUE INDEX `iduser_UNIQUE` (`id` ASC) VISIBLE)
                    ENGINE = InnoDB
                    DEFAULT CHARACTER SET = utf8
                    COLLATE = utf8_bin;""");
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void dropUsersTable() {

        try {
            preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS user");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO `user`.`user`(name, lastname, age) VALUES (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println(String.format("User с именем – %s добавлен в базу данных", name));
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void removeUserById(long id) {

        try  {
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<User> getAllUsers() {

        List<User> list = new LinkedList<>();
        ResultSet rs;
        try {
            preparedStatement = connection.prepareStatement("Select * from user");
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                list.add(new User(
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getByte("age"))
                );
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public void cleanUsersTable() {

        try {
            preparedStatement = connection.prepareStatement("TRUNCATE TABLE user");
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}