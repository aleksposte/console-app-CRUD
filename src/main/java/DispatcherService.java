import com.app.controller.LabelController;
import com.app.controller.PostController;
import com.app.controller.WriterController;
import com.app.view.LabelView;
import com.app.view.PostView;
import com.app.view.WriterView;

import java.util.Scanner;

public class DispatcherService {
    private final LabelController labelController = new LabelController();
    private final PostController postController = new PostController();
    private final WriterController wriController = new WriterController();

    private final LabelView labelView = new LabelView(labelController);
    private final PostView postView = new PostView(postController);
    private final WriterView writerView = new WriterView(wriController);

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        String menuMessage =
                "Choice and Enter: \n" +
                        "1. Label\n" +
                        "2. Post \n" +
                        "3. Writer \n" +
                        "0. Exit";
        System.out.println(menuMessage);

        while (true){
            String response = scanner.next();

            switch (response) {
                case "1" -> labelStart();
                case "2" -> postStart();
                case "3" -> writerStart();
                case "0" -> {
                    System.out.println("Exit Main Menu!");
                    System.exit(0);
                }
                default -> System.out.println("Wrong Num!");
            }
        }
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


