package com.app.view;

public class WriterView {
    public static void show() {
        String mainMessage = "Choose an action with writer: \n" +
                " 1. Create \n" +
                " 2. Update \n" +
                " 2. Delete \n" +
                " 3. Show writer by id \n" +
                " 4. Create or edit posts list for writer by ID \n" +
                " 5. Main menu \n" +
                " 6. Exit";
        System.out.println(mainMessage);
    }
}
