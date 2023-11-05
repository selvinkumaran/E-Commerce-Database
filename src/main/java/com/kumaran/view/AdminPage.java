package com.kumaran.view;

import com.kumaran.utils.StringUtils;

import static com.kumaran.utils.Utils.println;

public class AdminPage {
   public  void printUsers(){
        try {
            println(StringUtils.STYLE);
            println(StringUtils.VIEW_USERS);
            println(StringUtils.STYLE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
