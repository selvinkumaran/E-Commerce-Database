package com.kumaran.view;

import com.kumaran.utils.StringUtils;

import static com.kumaran.utils.Utils.println;

public class HomePage {

    public void printAdminMenu() {
        println(StringUtils.STYLE);
        println(StringUtils.WELCOME_MESSAGE);
        println(StringUtils.STYLE);
        println(StringUtils.ADMIN_MENU);
    }

    public void printMenu() {
        println(StringUtils.STYLE);
        println(StringUtils.WELCOME_MESSAGE);
        println(StringUtils.STYLE);
        println(StringUtils.HOME_MENU);
    }
}
