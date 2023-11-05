package com.kumaran.view;

import com.kumaran.utils.StringUtils;

import static com.kumaran.utils.Utils.println;

public class WelcomePage {
    public void welcome() {
        try {
            println(StringUtils.STYLE);
            println(StringUtils.WELCOME_MESSAGE);
            println(StringUtils.STYLE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
