package com.kumaran.dao;

import com.kumaran.db.DbConnection;
import com.kumaran.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kumaran.db.DbConnection.dbConnection;

public class CategoryDao {
    private static Connection connection = null;
    private final static String CATEGORY = "SELECT id, name FROM category";

    public CategoryDao() {
        connection = dbConnection();
    }

    public static String getAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.getCategoryName();
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList.toString();
    }
}
