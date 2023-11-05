package com.kumaran.controller;

import com.kumaran.controller.impl.I_CategoryController;
import com.kumaran.model.Category;
import com.kumaran.utils.AppException;
import com.kumaran.utils.StringUtils;
import com.kumaran.view.CategoryPage;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.kumaran.dao.CategoryDao.getAllCategory;
import static com.kumaran.dao.UserDao.getAllUsers;
import static com.kumaran.utils.AppInput.enterInt;
import static com.kumaran.utils.AppInput.enterString;
import static com.kumaran.utils.LoadUtils.getCategories;
import static com.kumaran.utils.Utils.println;

public class CategoryController implements I_CategoryController {

    private final CategoryPage categoryPage;
    private final ProductController productController;
    private final HomeController homeController;

    public CategoryController(HomeController homeController) {
        categoryPage = new CategoryPage();
        productController = new ProductController(homeController);
        this.homeController = homeController;
    }


    @Override
    public void printMenu() {
        ArrayList<Category> categories = getCategories();
        categoryPage.printMenu(categories);

        try {
            int choice = enterInt(StringUtils.ENTER_CHOICE);

            if (choice == 99) {
                homeController.printMenu();
            } else {
                int validCategoryId = 0;

                for (Category category : categories) {
                    if (category.getId() == choice) {
                        validCategoryId = category.getId();
                        break;
                    }
                }

                if (validCategoryId != 0) {
                    productController.showProducts(validCategoryId);
                } else {
                    invalidChoice(new AppException(StringUtils.INVALID_CHOICE));
                }
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }
    }

    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        printMenu();
    }

    @Override
    public void viewCategories() {
        categoryPage.AdminCategoryProducts();
        String categoryList= getAllCategory();
        println(categoryList);
        }

    @Override
    public void addCategories() {
        String categoryName;
        categoryName = enterString(StringUtils.ENTER_CATEGORY_NAME);
//        try {
//            FileWriter csvWriter = new FileWriter(getCategoryProducts(), true);
//            int id = (int) (Math.random() * 100);
//            csvWriter.append("\n");
//            csvWriter.append(id + "," + categoryName);
//            csvWriter.flush();
//            csvWriter.close();
//            categoryPage.printcategoriesAddedSuccessfully();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

@Override
    public void editCategories() throws AppException, IOException {
        int id = enterInt(StringUtils.ENTER_CATEGORY_ID);
        String categoryName = enterString(StringUtils.ENTER_CATEGORY_NAME);
        List<String[]> records = new ArrayList<>();
//        try (CSVReader reader = new CSVReader(new FileReader(getCategoryProducts()))) {
//            records = reader.readAll();
//        } catch (IOException | CsvException e) {
//            e.printStackTrace();
//        }
//
//        for (String[] record : records) {
//            if (!record[0].isEmpty()) {
//                try {
//                    int categoryIdFromRecord = Integer.parseInt(record[0].trim());
//                    if (categoryIdFromRecord == id) {
//                        record[1] = categoryName;
//                    }
//                } catch (NumberFormatException ex) {
//                }
//            }
//        }
//
//        try (CSVWriter writer = new CSVWriter(new FileWriter(getCategoryProducts(), false))) {
//            writer.writeAll(records);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        categoryPage.printCategoryEditedSuccessfully();
    }


    @Override
    public void deleteCategories() throws AppException {
        int id = enterInt(StringUtils.ENTER_CATEGORY_ID);
//        List<String[]> records = new ArrayList<>();
//        try (CSVReader reader = new CSVReader(new FileReader(getCategoryProducts()))) {
//            records = reader.readAll();
//        } catch (IOException | CsvException e) {
//            e.printStackTrace();
//        }
//        List<String[]> recordsToDelete = new ArrayList<>();
//
//        for (String[] record : records) {
//            try {
//                int categoryIdFromRecord = Integer.parseInt(record[0].trim());
//                if (categoryIdFromRecord != id) {
//                    recordsToDelete.add(record);
//                }
//            } catch (NumberFormatException ex) {
//            }
//        }
//        try (CSVWriter writer = new CSVWriter(new FileWriter(getCategoryProducts(), false))) {
//            writer.writeAll(recordsToDelete);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        categoryPage.printCategoryDeletedSuccessfully();

    }

}
