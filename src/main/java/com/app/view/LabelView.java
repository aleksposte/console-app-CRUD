package com.app.view;
import com.app.controller.LabelController;
import com.app.model.Label;
import com.app.poststatus.LabelStatus;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LabelView {
    private final LabelController labelController;

    Scanner scanner = new Scanner(System.in);
    boolean isExit = false;

    public LabelView(LabelController labelController) {
        this.labelController = labelController;
    }

    public void start() throws IOException {
        String menuMessage =
                "Choice and Enter: \n" +
                        "1. Create \n" +
                        "2. Read (Id) \n" +
                        "3. Update \n" +
                        "4. Delete \n" +
                        "5. Get All \n" +
                        "0. Exit";
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
                    read();
                }
                case "3" -> {
                    isExit = true;
                    update();
                }
                case "4" -> {
                    isExit = true;
                    delete();
                }
                case "5" -> {
                    isExit = true;
                    getAll();
                }
                case "0" -> {
                    System.out.println("exit Label!");
                    isExit = false;
                    System.exit(0);
                }
                default ->
                      System.out.println("wrong num!");
            }
        } while (!isExit);
    }

    public void create() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Label name: ");
        String name = scanner.nextLine();

        LabelStatus labelStatus = LabelStatus.ACTIVE;

        labelController.create(name, labelStatus);
        start();
    }

    public void read() throws IOException {
        System.out.println("Enter Label ID: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        labelController.read(id);
        System.out.println("Read Label Id: " + labelController.read(id).getName());
        start();
    }

    public void update() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Label ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter New Label: ");
        String name = scanner.nextLine();

        LabelStatus labelStatus = LabelStatus.ACTIVE;

        Label updateLabel = labelController.update(id, name, labelStatus);
        System.out.println("Update Label ID: " + updateLabel.getId() + " Label: " + updateLabel.getName());
        start();
    }

    public void delete() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Label ID: ");
        Integer id = scanner.nextInt();

        labelController.delete(id);
        System.out.println("Delete Label: " + id);
        start();
    }

    public void getAll() throws IOException {
        List<Label> labels = labelController.getAll();
        System.out.println("All Labels: ");
        for(Label label : labels){
            System.out.println(label.getName());
        }
        start();
    }
}
