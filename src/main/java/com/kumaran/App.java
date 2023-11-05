package com.kumaran;

import com.kumaran.controller.AppController;
import com.kumaran.utils.LoadUtils;

public class App {
    public static void main(String[] args) {
        AppController appController = new AppController();
        LoadUtils.load();
        appController.init();
    }
}