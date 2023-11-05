package com.kumaran.dao;

import com.kumaran.model.Product;
import com.kumaran.utils.AppException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kumaran.db.DbConnection.dbConnection;

public class ProductDao {
    private static Connection connection = null;
    private static final String DELETE = "DELETE FROM products WHERE id = ?";
    private static final String ALL_PRODUCT = "SELECT * FROM product";
    private static final String EDIT = "UPDATE products SET title = ?, description = ?, category = ?, price = ?, stocks = ? WHERE id = ?";
    private static final String ADD = "INSERT INTO products (name, category_id, price) VALUES (?, ?,?)";


    public ProductDao() {
        connection = dbConnection();
    }
    public static void addProduct(Product product) {
        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setString(1, product.getTitle());
            statement.setString(2, product.getCategory());
            statement.setInt(3, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(ALL_PRODUCT);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                products.add(mapResultSetToProduct(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public static void updateProduct(Product product) {
        try (PreparedStatement statement = connection.prepareStatement(EDIT)) {
            statement.setString(1, product.getTitle());
            statement.setString(2, product.getDescription());
            statement.setString(3, product.getCategory());
            statement.setInt(4, product.getPrice());
            statement.setInt(5, product.getStocks());
            statement.setInt(6, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(int productId) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static Product mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setTitle(resultSet.getString("name"));
        product.setCategory(resultSet.getString("category_id"));
        try {
            product.setPrice(resultSet.getInt("price"));
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
