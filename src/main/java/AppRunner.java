import com.app.controller.LabelController;
import com.app.controller.PostController;
import com.app.controller.WriterController;
import com.app.view.LabelView;
import com.app.view.PostView;
import com.app.view.WriterView;

import java.io.IOException;
import java.util.Scanner;

public class AppRunner {
    Scanner scanner = new Scanner(System.in);
    boolean isExit = false;

    public void start() throws Exception {
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
                    System.exit(0);
                }
                default -> System.out.println("Wrong Num!");
            }
        } while (!isExit);
        scanner.close();
    }

    public void labelStart() throws IOException {
        LabelController labelController = new LabelController();
        LabelView labelView = new LabelView(labelController);

        labelView.start();
    }

    public void postStart() throws IOException {
        PostController postController = new PostController();
        PostView postView = new PostView(postController);

        postView.start();
    }

    public void writerStart() throws IOException {
        WriterController wriController = new WriterController();
        WriterView writerView = new WriterView(wriController);

        writerView.start();
    }
};


