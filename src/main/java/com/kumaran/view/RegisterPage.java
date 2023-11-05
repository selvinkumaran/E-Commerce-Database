package com.kumaran.view;

import com.kumaran.utils.StringUtils;

import static com.kumaran.utils.Utils.println;

public class RegisterPage {

    public void printRegistrationSuccessful() {
        try {
            println(StringUtils.STYLE);
            println(StringUtils.REGISTRATION_SUCCESSFUL);
            println(StringUtils.STYLE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void InputMisMatch() {
        try {
            println(StringUtils.STYLE);
            println(StringUtils.INPUT_MISMATCH);
            println(StringUtils.STYLE);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
