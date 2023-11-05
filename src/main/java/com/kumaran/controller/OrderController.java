package com.kumaran.controller;

import com.kumaran.controller.impl.I_OrderController;
import com.kumaran.model.CartProduct;
import com.kumaran.model.User;
import com.kumaran.view.OrdersPage;

import static com.kumaran.utils.UserUtils.getLoggedInUser;

public class OrderController implements I_OrderController {

    private final HomeController homeController;
    private final OrdersPage ordersPage;
    private final AdminController adminController;


    public OrderController(HomeController homeController, OrdersPage ordersPage, AdminController adminController) {
        this.homeController = homeController;
        this.ordersPage = ordersPage;
        this.adminController = adminController;
    }

    @Override
    public void checkout() {
        User loggedInUser = getLoggedInUser();

//        try {
//            FileWriter fileWriter = new FileWriter(getFilePath() + System.currentTimeMillis() + ".txt");
//            fileWriter.write("Your Order are:");
//            fileWriter.write("\n");
//
//            double total = 0;
//            for (CartProduct cartProduct : loggedInUser.getUserCart().getCartProducts()) {
//                total += cartProduct.getCount() * cartProduct.getProduct().getPrice();
//                fileWriter.write(cartProduct.getProduct().getTitle() + " x " + cartProduct.getCount() + " = Rs. " + cartProduct.getProduct().getPrice() * cartProduct.getCount());
//                fileWriter.write("\n");
//            }
//            fileWriter.write("Total - Rs. " + total);
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        getLoggedInUser().setUserCart(null);
        homeController.printMenu();
    }

    @Override
    public void showOrders(){
        ordersPage.printOrders();
        adminController.viewOrders();

    }
}
