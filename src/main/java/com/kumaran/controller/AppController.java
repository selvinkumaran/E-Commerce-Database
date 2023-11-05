package com.kumaran.controller;

import com.kumaran.controller.impl.I_AppController;
import com.kumaran.view.WelcomePage;

public class AppController implements I_AppController {

    private final WelcomePage welcomePage;
    private final AuthController authController;

    public AppController() {
        welcomePage = new WelcomePage();
        authController = new AuthController();
    }

    @Override
    public void init() {
        welcomePage.welcome();
        authController.authMenu();
    }

}
