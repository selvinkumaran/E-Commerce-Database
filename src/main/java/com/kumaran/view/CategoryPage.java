package com.kumaran.view;

import com.kumaran.model.Category;
import com.kumaran.utils.StringUtils;

import java.util.ArrayList;

import static com.kumaran.utils.Utils.println;

public class CategoryPage {
    public void printMenu(ArrayList<Category> categories) {
        println(StringUtils.CATEGORY_MENU);
        for (Category category : categories) {
            println(category.getId() + ". " + category.getCategoryName());
        }
        println(StringUtils.BACK_OPTION);
    }
    public void AdminCategoryProducts() {
        println(StringUtils.STYLE);
        println(StringUtils.CATEGORY_MENU);
        println(StringUtils.STYLE);
    }

    public void viewProductsCategoryOperations() {
        println(StringUtils.STYLE);
        println(StringUtils.CATEGORY_MENU);
        println(StringUtils.STYLE);
        println(StringUtils.ADMIN_CATEGORY_MENU);
    }

    public void printcategoriesAddedSuccessfully() {
        println(StringUtils.STYLE);
        println(StringUtils.CATEGORY_ADDED_SUCCESS);
        println(StringUtils.STYLE);
    }

    public void printCategoryEditedSuccessfully() {
        println(StringUtils.STYLE);
        println(StringUtils.CATEGORY_EDITED_SUCCESS);
        println(StringUtils.STYLE);
    }
    public void printCategoryDeletedSuccessfully() {
        println(StringUtils.STYLE);
        println(StringUtils.CATEGORY_DELETED_SUCCESS);
        println(StringUtils.STYLE);
    }
}
