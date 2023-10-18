package com.app.view;
import com.app.controller.LabelController;
import com.app.model.Label;
import com.app.poststatus.LabelStatus;

import java.util.List;
import java.util.Scanner;

public class LabelView {
    private final LabelController labelController;
    public LabelView(LabelController labelController) {
        this.labelController = labelController;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        String menuMessage =
                "Choose and Enter: \n" +
                        "1. Create \n" +
                        "2. Read (Id) \n" +
                        "3. Update \n" +
                        "4. Delete \n" +
                        "5. Get All \n" +
                        "0. Exit";
        System.out.println(menuMessage);

        while(true) {
            String response = scanner.next();

            switch(response) {
                case "1" -> create();
                case "2" -> read();
                case "3" -> update();
                case "4" -> delete();
                case "5" -> getAll();
                case "0" -> System.out.println("exit Label!");
                default -> System.out.println("wrong num!");
            }
        }
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Label name: ");
        String name = scanner.nextLine();

        LabelStatus labelStatus = LabelStatus.ACTIVE;

        labelController.create(name, labelStatus);
        start();
    }

    public void read() {
        System.out.println("Enter Label ID: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        labelController.read(id);
        System.out.println("Read Label Id: " + labelController.read(id).getName());
        start();
    }

    public void update() {
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

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Label ID: ");
        Integer id = scanner.nextInt();

        labelController.delete(id);
        System.out.println("Delete Label: " + id);
        start();
    }

    public void getAll() {
        List<Label> labels = labelController.getAll();
        System.out.println("All Labels: ");
        for(Label label : labels){
            System.out.println(label.getName());
        }
        start();
    }
}
