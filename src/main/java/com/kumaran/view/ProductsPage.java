package com.kumaran.view;

import com.kumaran.model.Product;
import com.kumaran.utils.StringUtils;

import java.util.ArrayList;

import static com.kumaran.utils.Utils.println;

public class ProductsPage {
    public void printProducts(ArrayList<Product> products) {
        println(StringUtils.PRODUCT_MENU);
        for (Product product : products) {
            println(product.getId() + ". " + product.getTitle() + " - Rs." + product.getPrice());
        }
        println(StringUtils.BACK_OPTION);
    }

    public void AdminProducts() {
        println(StringUtils.STYLE);
        println(StringUtils.PRODUCT_MENU);
        println(StringUtils.STYLE);
    }

    public void viewProductsOperaions() {
        println(StringUtils.STYLE);
        println(StringUtils.PRODUCT_MENU);
        println(StringUtils.STYLE);
        println(StringUtils.ADMIN_PRODUCT_MENU);
    }
    public void printSuccess() {
        println(StringUtils.STYLE);
        println(StringUtils.CART_SUCCESS);
        println(StringUtils.STYLE);
    }
    public void printProductAddedSuccessfully() {
        println(StringUtils.STYLE);
        println(StringUtils.PRODUCT_ADDED_SUCCESS);
        println(StringUtils.STYLE);
    }

    public void printProductEditedSuccessfully() {
        println(StringUtils.STYLE);
        println(StringUtils.PRODUCT_EDITED_SUCCESS);
        println(StringUtils.STYLE);
    }
    public void printProductDeletedSuccessfully() {
        println(StringUtils.STYLE);
        println(StringUtils.PRODUCT_DELETED_SUCCESS);
        println(StringUtils.STYLE);
    }
    public void printProductDoesNotExist() {
        println(StringUtils.STYLE);
        println(StringUtils.PRODUCT_NOT_EXIST);
        println(StringUtils.STYLE);
    }
}
