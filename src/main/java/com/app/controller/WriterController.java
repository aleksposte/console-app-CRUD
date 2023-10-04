package com.app.controller;

import com.app.view.WriterView;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class WriterController {
    public static void start() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        do {
            String responce = scanner.next();
            WriterView.show();

            switch (responce) {
                case "1" -> create();
                case "2" -> update();
                case "3" -> delete();
                case "4" -> show();
                case "5" -> addListElementsForWriter();
                case "6" -> {
                    isExit = true;
                }
                case "7" -> isExit = true;
                // default - > обработать невравильный ввод цифры
            }
        } while (!isExit);
        scanner.close();
    }

    public static void create() throws FileNotFoundException {
        System.out.println("create");
    }

    public static void update() throws FileNotFoundException {}

    public static void delete() throws FileNotFoundException {
        System.out.println("delete");
    }

    public static void show() throws FileNotFoundException {
        System.out.println("show");
    }

    public static void addListElementsForWriter() throws FileNotFoundException {
        System.out.println("add elem");
    }
//    public static ArrayList<Post> addListPostsForWriterById(int wrId) throws FileNotFoundException {}
}
