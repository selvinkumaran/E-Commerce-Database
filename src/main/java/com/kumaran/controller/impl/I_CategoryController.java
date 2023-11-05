package com.kumaran.controller.impl;

import com.kumaran.utils.AppException;

import java.io.IOException;

public interface I_CategoryController {
    void printMenu();
    void viewCategories();

    void addCategories();


    void editCategories() throws AppException, IOException;

    void deleteCategories() throws AppException;
}
