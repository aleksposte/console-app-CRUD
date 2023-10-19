package com.app.view;
import com.app.controller.LabelController;
import com.app.controller.PostController;
import com.app.model.Label;
import com.app.model.Post;
import com.app.poststatus.LabelStatus;
import com.app.poststatus.PostStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PostView {
    private final PostController postController;
    public PostView(PostController postController) { this.postController = postController; }

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        String menuMessage =
                "Choose and Enter: \n" +
                        "1. Create \n" +
                        "2. Read (Id) \n" +
                        "3. Update \n" +
                        "4. Delete \n" +
                        "5. Get All \n" +
                        "6. Add Label to Post \n" +
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
                case "6" -> addLabelToPost();
                case "0" -> System.out.println("exit Post!");
                default -> System.out.println("wrong num!");
            }
        }
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Post name: ");
        String name = scanner.nextLine();

        Date created = new Date();
        Date updated = new Date();
        PostStatus postStatus = PostStatus.ACTIVE;
        List<Label> labels = new ArrayList<>();

        postController.create(name, created, updated, postStatus, labels);
        start();
    }

    public void read() {
        System.out.println("Enter Post ID: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        postController.read(id);
        System.out.println("Read Post Id: " + postController.read(id).getName());
        start();
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Post ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter New Post: ");
        String name = scanner.nextLine();

        Date created = new Date();
        Date updated = new Date();
        PostStatus postStatus = PostStatus.ACTIVE;
        List<Label> labels = new ArrayList<>();

        Post updatePost = postController.update(id, name, created, updated, postStatus, labels);
        System.out.println("Update Post ID: " + updatePost.getId() + " Post: " + updatePost.getName());
        start();
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Post ID: ");
        Integer id = scanner.nextInt();

        postController.delete(id);
        System.out.println("Delete Post: " + id);
        start();
    }

    public void getAll() {
        List<Post> labels = postController.getAll();
        System.out.println("All Posts: ");
        for(Post label : labels){
            System.out.println(label.getName());
        }
        start();
    }

    public void addLabelToPost() {
        LabelController labelController = new LabelController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Post ID For Add Label: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Label: ");
        String name = scanner.nextLine();

        Label label = labelController.create(name, LabelStatus.ACTIVE);
        postController.addLabelToPost(id, label);
        start();
    }
}
