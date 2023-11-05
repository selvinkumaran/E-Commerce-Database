package com.kumaran.view;

import com.kumaran.utils.StringUtils;

import static com.kumaran.utils.Utils.println;

public class LoginPage {

    public void printLoginSuccessful() {
        try {
            println(StringUtils.STYLE);
            println(StringUtils.LOGIN_SUCCESSFULLY);
            println(StringUtils.STYLE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printInvalidCredentials() {
        try {
            println(StringUtils.STYLE);
            println(StringUtils.INVALID_CREDENTIALS);
            println(StringUtils.STYLE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
