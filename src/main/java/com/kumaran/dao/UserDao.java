package com.kumaran.dao;

import com.kumaran.db.DbConnection;
import com.kumaran.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kumaran.db.DbConnection.dbConnection;

public class UserDao {
    private static Connection connection = null;

    public UserDao() {
        connection = dbConnection();
    }

    private final static String sqlLogin = "SELECT id, name, email, password FROM user WHERE email = ? AND password = ?";
    private final static String sqlRegister = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
    private final static String allUser = "SELECT id, name ,email FROM user";

    public static User loginUser(String email, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlLogin);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registerUser(String name, String email, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRegister);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(allUser);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList.toString();
    }
}