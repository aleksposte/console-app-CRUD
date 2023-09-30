package com.app.controller;

import com.app.view.MainMenu;

import java.util.Scanner;

public class MainController {
    public static void startMain() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        do {
            MainMenu.start();
            String responce = scanner.next();

            switch (responce) {
                case "1" -> {
                    isExit = true;
                    WriterController.start();
                }
                case "2" -> {
                    isExit = true;
//                    PostController.start();
                }
                case "3" -> {
                    isExit = true;
//                    LabelController.start();
                }
                case "4" -> {
                    isExit = true;
                    break;
                }
//                default: // обработать ошибку ввода
            }
        } while (!isExit);
        scanner.close();
    }
}
