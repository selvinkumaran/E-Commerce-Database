package com.kumaran.view;

import com.kumaran.utils.StringUtils;

import static com.kumaran.utils.Utils.println;

public class OrdersPage {

    public  void printOrders(){
        try {
            println(StringUtils.STYLE);
            println(StringUtils.VIEW_ORDERS);
            println(StringUtils.STYLE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
