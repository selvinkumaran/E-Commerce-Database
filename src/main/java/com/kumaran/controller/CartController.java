package com.kumaran.controller;

import com.kumaran.controller.impl.I_CartController;
import com.kumaran.model.*;
import com.kumaran.utils.AppException;
import com.kumaran.utils.StringUtils;
import com.kumaran.view.CartPage;

import java.util.ArrayList;

import static com.kumaran.utils.AppInput.enterInt;
import static com.kumaran.utils.LoadUtils.getProducts;
import static com.kumaran.utils.UserUtils.getLoggedInUser;
import static com.kumaran.utils.UserUtils.setLoggedInUser;
import static com.kumaran.utils.Utils.println;

public class CartController implements I_CartController {

    private final HomeController homeController;
    private final OrderController orderController;
    private final CartPage cartPage;


    public CartController(HomeController homeController) {
        this.homeController = homeController;
        orderController = new OrderController(homeController, null, null);
        cartPage = new CartPage();
    }

    @Override
    public void addToCart(int productId) {
        User loggedInUser = getLoggedInUser();
        ArrayList<Product> products = getProducts();

        Product userProduct = null;
        for (Product product : products) {
            if (product.getId() == productId) {
                userProduct = product;
                break;
            }
        }

        if (loggedInUser.getUserCart() != null) {
            Cart cart = loggedInUser.getUserCart();

            boolean isFound = false;
            for (CartProduct cartProduct : cart.getCartProducts()) {
                if (cartProduct.getProduct().getId() == productId) {
                    cartProduct.setCount(cartProduct.getCount() + 1);
                    isFound = true;
                }
            }

            if (!isFound) {
                cart.getCartProducts().add(new CartProduct(userProduct, 1));
            }

            loggedInUser.setUserCart(cart);
        } else {
            Cart cart = new Cart();
            ArrayList<CartProduct> cartProducts = new ArrayList<>();
            cartProducts.add(new CartProduct(userProduct, 1));
            cart.setCartProducts(cartProducts);
            loggedInUser.setUserCart(cart);
        }
        setLoggedInUser(loggedInUser);
    }

    private void checkout() {
        orderController.checkout();
    }

    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        printCart();
    }

    @Override
    public void printCart() {
        User loggedInUser = getLoggedInUser();
        if (loggedInUser.getUserCart() == null) {
            cartPage.printEmptyCart();
            homeController.printMenu();
        } else {
            ArrayList<CartProduct> cartProducts = loggedInUser.getUserCart().getCartProducts();
            cartPage.printCart(cartProducts);

            cartPage.printCheckout();
            cartPage.printBack();

            try {
                int choice = enterInt(StringUtils.ENTER_CHOICE);
                if (choice == 88) {
                    checkout();
                } else if (choice == 99) {
                    homeController.printMenu();
                } else {
                    invalidChoice(new AppException(StringUtils.INVALID_CHOICE));
                }
            } catch (AppException appException) {
                invalidChoice(appException);
            }

        }
    }
}
