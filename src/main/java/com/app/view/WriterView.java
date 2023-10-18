package com.app.view;
import com.app.controller.PostController;
import com.app.controller.WriterController;
import com.app.model.Label;
import com.app.model.Post;
import com.app.model.Writer;
import com.app.poststatus.PostStatus;
import com.app.poststatus.WriterStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WriterView {
    private final WriterController writerController;
    public WriterView(WriterController writerController) {
        this.writerController = writerController;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        String mainMessage = "Choose and Enter: \n" +
                "1. Create \n" +
                "2. Read (Id) \n" +
                "3. Update \n" +
                "4. Delete \n" +
                "5. Get All \n" +
                "6. Add Post To Writer \n" +
                "0. Exit";
        System.out.println(mainMessage);

        while(true) {
            String response = scanner.next();

            switch(response) {
                case "1" -> create();
                case "2" -> read();
                case "3" -> update();
                case "4" -> delete();
                case "5" -> getAll();
                case "6" -> addPostToWriter();
                case "0" -> System.out.println("exit Writer!");
                default -> System.out.println("wrong num!");
            }
        }
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter  FirstName: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter LastName: ");
        String lastName = scanner.nextLine();

        WriterStatus writerStatus = WriterStatus.ACTIVE;
        List<Post> posts = new ArrayList<>();

        writerController.create(firstName, lastName, writerStatus, posts);
        start();
    }

    public void read() {
        System.out.println("Enter Writer ID: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        writerController.read(id);
        System.out.println("Read Writer: " + writerController.read(id).getFirstName() + " " + writerController.read(id).getLastName());
        start();
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Writer ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter New Writer FirstName: ");
        String firstName = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Enter New Writer LastName: ");
        String lastName = scanner.nextLine();

        WriterStatus writerStatus = WriterStatus.ACTIVE;
        List<Post> posts = new ArrayList<>();

        Writer updateWriter = writerController.update(id, firstName, lastName, writerStatus, posts);
        System.out.println("Update Writer ID: " + updateWriter.getId() + " FirstName: " + updateWriter.getFirstName() + " Last Name: " + updateWriter.getLastName());
        start();
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Writer ID: ");
        Integer id = scanner.nextInt();

        writerController.delete(id);
        System.out.println("Delete Writer: " + id);
        start();
    }

    public void getAll() {
        List<Writer> writers = writerController.getAll();
        System.out.println("All Writers: ");
        for(Writer writer : writers){
            System.out.println(writer.getFirstName() + " " + writer.getLastName());
        }
        start();
    }

    public void addPostToWriter() {
        PostController postController = new PostController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Writer ID For Add Post: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Post: ");
        String name = scanner.nextLine();

        Date created = new Date();
        Date updated = new Date();
        PostStatus postStatus = PostStatus.ACTIVE;
        List<Label> labels = new ArrayList<>();

        Post post = postController.create(name, created, updated, postStatus, labels);
        writerController.addPostToWriter(id, post);
        start();
    }
}
