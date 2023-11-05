package com.kumaran.controller;

import com.kumaran.controller.impl.I_ProductController;
import com.kumaran.dao.ProductDao;
import com.kumaran.model.Product;
import com.kumaran.utils.AppException;
import com.kumaran.utils.StringUtils;
import com.kumaran.view.ProductsPage;


import java.util.List;

import static com.kumaran.dao.ProductDao.*;
import static com.kumaran.utils.AppInput.enterInt;
import static com.kumaran.utils.AppInput.enterString;
import static com.kumaran.utils.Utils.println;

public class ProductController implements I_ProductController {

    private int categoryId = 0;
    private ProductsPage productsPage;
    private CartController cartController;
    private HomeController homeController;
    private  ProductDao productDao;


    public ProductController(HomeController homeController) {
        productDao=new ProductDao();
        productsPage = new ProductsPage();
        this.homeController = homeController;
        cartController = new CartController(homeController);
    }

    public ProductController() {
        productsPage = new ProductsPage();
    }

    @Override
    public void showProducts(int categoryId) {

    }

    @Override
    public void viewProducts() {
        productsPage.AdminProducts();
        List<Product> allProducts=getAllProducts();
        println(allProducts.toString());
    }

    @Override
    public void addProducts() {
        String title, description, category;
        int price, stocks;
        title = enterString(StringUtils.ENTER_TITLE);
        description = enterString(StringUtils.ENTER_DESCRIPTION);
        try {
            price = enterInt(StringUtils.ENTER_PRICE);
            stocks = enterInt(StringUtils.ENTER_STOCKS);
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        category = enterString(StringUtils.ENTER_CATEGORY);
        Product newProduct = new Product();
        newProduct.setTitle(title);
        newProduct.setDescription(description);
        newProduct.setCategory(category);
        try {
            newProduct.setPrice(price);
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        newProduct.setStocks(stocks);

        addProduct(newProduct);
    }

    @Override
//    public void showProducts(int categoryId) {
//        this.categoryId = categoryId;
//        ArrayList<Product> products = getProducts();
//        if (categoryId != 0) {
//            ArrayList<Product> categoryProducts = new ArrayList<>();
//            for (Product product : products) {
////                if (Integer.parseInt(product.getCategory().getId()) == categoryId) {
//                    categoryProducts.add(product);
//                }
//            }
//            products = categoryProducts;
//        }
//
//        productsPage.printProducts(products);
//
//        try {
//            int choice = enterInt(StringUtils.ENTER_CHOICE);
//            int validProductId = 0;
//
//            if (choice == 99) {
//                homeController.printMenu();
//            } else {
//                for (Product product : products) {
//                    if (product.getId() == choice) {
//                        validProductId = product.getId();
//                        break;
//                    }
//                }
//
//                if (validProductId != 0) {
//                    cartController.addToCart(validProductId);
//                    productsPage.printSuccess();
//                    showProducts(categoryId);
//                } else {
//                    invalidChoice(new AppException(StringUtils.INVALID_CHOICE));
//                }
//            }
//        } catch (AppException appException) {
//            invalidChoice(appException);
//        }
//    }


    public void editProducts() throws AppException {
        int id = enterInt(StringUtils.ENTER_CATEGORY_ID);
        String title, description, category;
        int price, stocks;
        title = enterString(StringUtils.ENTER_TITLE);
        description = enterString(StringUtils.ENTER_DESCRIPTION);
        try {
            price = enterInt(StringUtils.ENTER_PRICE);
            stocks = enterInt(StringUtils.ENTER_STOCKS);
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        category = enterString(StringUtils.ENTER_CATEGORY);
        Product updatedProduct = new Product();
        updatedProduct.setId(id);
        updatedProduct.setTitle(title);
        updatedProduct.setDescription(description);
        updatedProduct.setCategory(category);
        updatedProduct.setPrice(price);
        updatedProduct.setStocks(stocks);

        updateProduct(updatedProduct);

    }


    @Override
    public void deleteProducts() {
        int id = 0;
        try {
            id = enterInt(StringUtils.ENTER_ID);
            deleteProduct(id);
        } catch (AppException e) {
            throw new RuntimeException(e);
        }
        productsPage.printProductDeletedSuccessfully();
    }


    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        showProducts(categoryId);
    }
}
