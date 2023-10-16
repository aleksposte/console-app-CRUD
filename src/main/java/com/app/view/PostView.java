package com.app.view;

import com.app.controller.LabelController;
import com.app.controller.PostController;
import com.app.model.Label;
import com.app.model.Post;
import com.app.poststatus.LabelStatus;
import com.app.poststatus.PostStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PostView {
    private final PostController postController;

    Scanner scanner = new Scanner(System.in);
    boolean isExit = false;

    public PostView(PostController postController) {
        this.postController = postController;
    }

    public void start() throws IOException {
        String menuMessage =
                "Choice and Enter: \n" +
                        "1. Create \n" +
                        "2. Read (Id) \n" +
                        "3. Update \n" +
                        "4. Delete \n" +
                        "5. Get All \n" +
                        "6. Add Label to Post \n" +
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
                case "6" -> {
                    isExit = true;
                    addLabelToPost();
                }
                case "0" -> {
                    System.out.println("exit Post!");
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
        System.out.println("Enter Post name: ");
        String name = scanner.nextLine();

        Date created = new Date();
        Date updated = new Date();
        PostStatus postStatus = PostStatus.ACTIVE;
        List<Label> labels = new ArrayList<Label>();

        postController.create(name, created, updated, postStatus, labels);
        start();
    }

    public void read() throws IOException {
        System.out.println("Enter Post ID: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        postController.read(id);
        System.out.println("Read Post Id: " + postController.read(id).getName());
        start();
    }

    public void update() throws IOException {
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

    public void delete() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Post ID: ");
        Integer id = scanner.nextInt();

        postController.delete(id);
        System.out.println("Delete Post: " + id);
        start();
    }

    public void getAll() throws IOException {
        List<Post> labels = postController.getAll();
        System.out.println("All Posts: ");
        for(Post label : labels){
            System.out.println(label.getName());
        }
        start();
    }

    public void addLabelToPost() throws IOException {
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
