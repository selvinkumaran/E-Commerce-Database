package com.kumaran.dao;

import com.kumaran.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kumaran.db.DbConnection.dbConnection;

public class OrderDao {
    private static Connection connection = null;

    public OrderDao() {
        connection = dbConnection();

    }

    private static final String ALL_ORDERS = "SELECT id, date FROM orders";

//    SELECT o.id,o.date, u.name, u.email,s.status
//    FROM(( orders AS o INNER JOIN user AS u ON o.user_id = u.id)
//    INNER JOIN status AS s  ON o.status_id = s.id);

    public static String getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(ALL_ORDERS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setDate(String.valueOf(resultSet.getDate("date")));

                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList.toString();
    }
}
