package com.kumaran.model;

import java.util.ArrayList;

public class Order {
    private int id;
    private String date;
    private ArrayList<Cart> cart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Cart> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Cart> cart) {
        this.cart = cart;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "\nOrder --> " +
                "id:  " + id +
                "  date: " + date  +
                "  cart: " + cart ;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Cart> getCartProducts() {
        return cart;
    }

    public void setCartProducts(ArrayList<Cart> cart) {
        this.cart = cart;
    }
}
