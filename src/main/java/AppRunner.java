import com.app.controller.LabelController;
import com.app.controller.PostController;
import com.app.view.LabelView;
import com.app.view.PostView;


import java.io.IOException;
import java.util.Scanner;

public class AppRunner {
    Scanner scanner = new Scanner(System.in);
    boolean isExit = false;

    public void start() throws Exception {
//        LabelStart(); // start Label!
PostStart();
        String menuMessage =
                "Choice and Enter: \n" +
                        "1. Writer \n" +
                        "2. Post \n" +
                        "3. Label \n" +
                        "4. Exit";
//        System.out.println(menuMessage);

        do {
            String responce = scanner.next();

            switch (responce) {
                case "1" -> {
                    isExit = true;
//                    Writer.start();
                }
                case "2" -> {
                    isExit = true;
                    PostStart();
                }
                case "3" -> {
                    isExit = true;
                    LabelStart();
                }
                case "4" -> {
                    isExit = true;
                    break;
                }
                //  default: // обработать ошибку ввода
            }
        } while (!isExit);
        scanner.close();
    }

    public void LabelStart() throws IOException {
        LabelController labelController = new LabelController();
        LabelView labelView = new LabelView(labelController);

        labelView.start();
    }

    public void PostStart() throws IOException {
        PostController labelController = new PostController();
        PostView PostView = new PostView(labelController);

        PostView.start();
    }
};


