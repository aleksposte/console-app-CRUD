import com.app.controller.LabelController;
import com.app.controller.WriterController;


import java.io.IOException;
import java.util.Scanner;

public class AppRunner {
    Scanner scanner = new Scanner(System.in);
    boolean isExit = false;

    public void start() throws Exception {
        String menuMessage =
                "Choice and Enter: \n" +
                        "1. Writer \n" +
                        "2. Post \n" +
                        "3. Label \n" +
                        "4. Exit";
        System.out.println(menuMessage);

        do {
            String responce = scanner.next();

            switch (responce) {
                case "1" -> {
                    isExit = true;
//                    Writer.start();
                }
                case "2" -> {
                    isExit = true;
//                    Post.start();
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
        labelController.start();
    }
};


