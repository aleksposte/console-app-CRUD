import com.app.controller.LabelController;
import com.app.controller.PostController;
import com.app.controller.WriterController;
import com.app.view.LabelView;
import com.app.view.PostView;
import com.app.view.WriterView;

import java.util.Scanner;

public class AppRunner {
    LabelController labelController = new LabelController();
    LabelView labelView = new LabelView(labelController);

    PostController postController = new PostController();
    PostView postView = new PostView(postController);

    WriterController wriController = new WriterController();
    WriterView writerView = new WriterView(wriController);

    Scanner scanner = new Scanner(System.in);
    boolean isExit = false;

    public void start() {
        String menuMessage =
                "Choice and Enter: \n" +
                        "1. Label\n" +
                        "2. Post \n" +
                        "3. Writer \n" +
                        "0. Exit";
        System.out.println(menuMessage);

        do {
            String responce = scanner.next();

            switch (responce) {
                case "1" -> labelStart();
                case "2" -> postStart();
                case "3" -> writerStart();
                case "0" -> {
                    System.out.println("Exit Main Menu!");
                    isExit = false;
                }
                default -> System.out.println("Wrong Num!");
            }
        } while (!isExit);
        scanner.close();
    }

    public void labelStart() {
        labelView.start();
    }

    public void postStart() {
        postView.start();
    }

    public void writerStart() {
        writerView.start();
    }
};


