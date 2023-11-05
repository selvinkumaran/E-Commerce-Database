package com.kumaran.controller;

import com.kumaran.controller.impl.I_AuthController;
import com.kumaran.dao.UserDao;
import com.kumaran.model.Role;
import com.kumaran.model.User;
import com.kumaran.utils.AppException;
import com.kumaran.utils.StringUtils;
import com.kumaran.view.AuthPage;
import com.kumaran.view.LoginPage;
import com.kumaran.view.LogoutPage;
import com.kumaran.view.RegisterPage;

import static com.kumaran.utils.AppInput.enterInt;
import static com.kumaran.utils.AppInput.enterString;
import static com.kumaran.utils.UserUtils.setLoggedInUser;
import static com.kumaran.utils.Utils.println;

public class AuthController implements I_AuthController {

    private final HomeController homeController;
    private final LoginPage loginPage;
    private final RegisterPage registerPage;
    private final LogoutPage logoutPage;
    private final AuthPage authPage;
    private final UserDao userDao;

    public AuthController() {
        userDao = new UserDao();
        authPage = new AuthPage();
        homeController = new HomeController(this);
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        logoutPage = new LogoutPage();
    }

    @Override
    public void authMenu() {
        authPage.printAuthMenu();
        int choice;
        try {
            choice = enterInt(StringUtils.ENTER_CHOICE);
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else {
                invalidChoice(new AppException(StringUtils.INVALID_CHOICE));
            }
        } catch (AppException appException) {
            invalidChoice(appException);
        }
    }

    @Override
    public void login() {
        String email, password;
        email = enterString(StringUtils.ENTER_EMAIL);
        password = enterString(StringUtils.ENTER_PASSWORD);
        User user = UserDao.loginUser(email, password);
        if (user != null) {
            if (user.getEmail().equals("admin@admin.com") && user.getPassword().equals("admin")) {
                setLoggedInUser(user);
                loginPage.printLoginSuccessful();
                homeController.printAdminMenu();
            } else {
                setLoggedInUser(user);
                loginPage.printLoginSuccessful();
                homeController.printMenu();
            }
        } else {
            loginPage.printInvalidCredentials();
            authMenu();
        }
    }

    @Override
    public void register() {
        String name, email, password, c_password;
        name = enterString(StringUtils.ENTER_NAME);
        email = enterString(StringUtils.ENTER_EMAIL);
        password = enterString(StringUtils.ENTER_PASSWORD);
        c_password = enterString(StringUtils.ENTER_PASSWORD_AGAIN);

        if (isValidName(name) && isValidEmail(email) && isValidPassword(password) && password.equals(c_password)) {
            if (userDao.registerUser(name, email, password)) {
                registerPage.printRegistrationSuccessful();
            } else {
                System.out.println("Registration failed. Please try again.");
            }
        } else {
            registerPage.InputMisMatch();
        }
        authMenu();
    }

    private boolean isValidName(String name) {
        String nameRegex = "^[A-Za-z\\s]+$";
        return name.matches(nameRegex);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$";
        return password.matches(passwordRegex);
    }

    @Override
    public void logout() {
        logoutPage.printLogout();

    }


    private void invalidChoice(AppException e) {
        println(StringUtils.STYLE);
        println(e.getMessage());
        println(StringUtils.STYLE);
        authMenu();
    }
}
