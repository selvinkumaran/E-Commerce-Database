package com.kumaran.controller;

import com.kumaran.controller.impl.I_HomeController;
import com.kumaran.utils.AppException;
import com.kumaran.utils.StringUtils;
import com.kumaran.view.HomePage;
import com.kumaran.view.OrdersPage;

import static com.kumaran.utils.AppInput.enterInt;
import static com.kumaran.utils.UserUtils.setLoggedInUser;
import static com.kumaran.utils.Utils.println;

public class HomeController implements I_HomeController {

    private final HomePage homePage;
    private AuthController authController;
    private AdminController adminController;
    private CategoryController categoryController;
    private ProductController productController;
    private CartController cartController;
    private OrderController orderController;
    private OrdersPage ordersPage;

    public HomeController(AuthController authController) {
        homePage = new HomePage();
        this.authController = authController;
        adminController = new AdminController();
        ordersPage = new OrdersPage();
        orderController = new OrderController(null, ordersPage, adminController);
        productController = new ProductController(this);
        categoryController = new CategoryController(this);
        cartController = new CartController(this);
    }

    public HomeController() {
        homePage = new HomePage();
    }


    @Override
    public void printAdminMenu() {
        homePage.printAdminMenu();
        try {
            int choice = enterInt(StringUtils.ENTER_CHOICE);
            if (choice == 1) {
                adminController.viewUsers();
                printAdminMenu();
            } else if (choice == 2) {
                adminController.productsOperations();
                printAdminMenu();
            } else if (choice == 3) {
                adminController.categoryOperations();
                printAdminMenu();
            } else if (choice == 4) {
                orderController.showOrders();
                printAdminMenu();
            } else if (choice == 5) {
                setLoggedInUser(null);
                authController.logout();
                authController.authMenu();
            } else {
                invalidChoice(new AppException(StringUtils.INVALID_CHOICE));
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }
    }

    @Override
    public void printMenu() {
        homePage.printMenu();
        try {
            int choice = enterInt(StringUtils.ENTER_CHOICE);
            if (choice == 1) {
                categoryController.printMenu();
            } else if (choice == 2) {
                productController.showProducts(0);
            } else if (choice == 3) {
                cartController.printCart();
            } else if (choice == 4) {
                orderController.showOrders();
                printMenu();
            } else if (choice == 5) {
                setLoggedInUser(null);
                authController.logout();
                authController.authMenu();
            } else {
                invalidChoice(new AppException(StringUtils.INVALID_CHOICE));
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }
    }

    private void invalidChoice(AppException appException) {
        println(appException.getMessage());
        printMenu();
    }
}
