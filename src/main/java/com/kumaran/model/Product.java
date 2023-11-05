package com.kumaran.model;

import com.kumaran.utils.AppException;

public class Product {
    private int id;
    private String title;
    private String description;
    private double price;
    private int stocks;
    private String category;

    public Product(int id, String title, String description, double price, int stocks, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stocks = stocks;
        this.category = String.valueOf(category);
    }

    public Product() {

    }

    public Product(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return (int) price;
    }

    public void setPrice(double price) throws AppException {
        if (price <= 0) {
            throw new AppException("Price Cannot be negative");
        }
        this.price = price;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
