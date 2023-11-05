package com.kumaran.controller.impl;

import com.kumaran.utils.AppException;

public interface I_ProductController {
    void showProducts(int categoryId);

    void viewProducts();

    void addProducts();

    void editProducts() throws AppException;

    void deleteProducts();
}
