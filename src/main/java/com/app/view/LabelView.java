package com.app.view;
import com.app.controller.LabelController;
import com.app.model.Label;
import com.app.repository.LabelRepository;
//import sun.awt.ComponentFactory;

import java.io.IOException;
import java.util.Scanner;

public class LabelView {
//    private final LabelController labelController;

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        String menuMessage =
                "Choice and Enter: \n" +
                        "1. Create \n" +
                        "2. Get \n" +
                        "3. Label \n" +
                        "4. Exit";
        System.out.println(menuMessage);

        do {
            String responce = scanner.next();

            switch (responce) {
                case "1" -> {
                    isExit = true;
                    create();
                }
                case "2" -> {
                    isExit = true;

                }
                case "3" -> {
                    isExit = true;

                }
                case "4" -> {
                    isExit = true;
                    break;
                }
                //  default: // обработать ошибку ввода
            }
        } while (!isExit);
//        scanner.close();
    }

//    public LabelView(LabelController labelController) {
//        this.labelController = labelController;
//        this.scanner = new Scanner(System.in);
//    }

    public void create() throws IOException {
        System.out.println("Enter name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

//        LabelStatus labelStatus = LabelStatus.ACTIVE;


        LabelController labelController = new LabelController();
        labelController.create(name);
    }
}
