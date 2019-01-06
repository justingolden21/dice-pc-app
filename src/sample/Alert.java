package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {

    public static void display(String title, String[] messages) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(Main.WINDOW_MIN_HEIGHT);
        window.setMinWidth(Main.WINDOW_MIN_HEIGHT);


        FlowPane flowpane = new FlowPane();

        for(int i=0; i<messages.length; i++) {
//            System.out.println(messages[i]);
            Label label = new Label("\n\n" + messages[i] + "\n\n");
            Label label2 = new Label("\n\n");
            StackPane sp = new StackPane(label);
            StackPane sp2 = new StackPane(label2);
            flowpane.getChildren().addAll(sp, sp2);
        }


        BorderPane layout = new BorderPane();
        layout.setCenter(flowpane);



        Scene scene = new Scene(layout, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        scene.getStylesheets().add("/css/styles.css");
        window.setScene(scene);

        window.getIcons().addAll(
                new Image("/img/icon16.ico"),
                new Image("/img/icon24.ico"),
                new Image("/img/icon32.ico"),
                new Image("/img/icon40.ico"),
                new Image("/img/icon48.ico"),
                new Image("/img/icon64.ico"),
                new Image("/img/icon128.ico"),
                new Image("/img/icon256.ico"),

                new Image("/img/icon16.png"),
                new Image("/img/icon24.png"),
                new Image("/img/icon32.png"),
                new Image("/img/icon40.png"),
                new Image("/img/icon48.png"),
                new Image("/img/icon64.png"),
                new Image("/img/icon128.png"),
                new Image("/img/icon256.png"),

                new Image("/img/icon16.icns"),
                new Image("/img/icon32.icns"),
                new Image("/img/icon48.icns"),
                new Image("/img/icon128.icns"),
                new Image("/img/icon256.icns")
        );

        window.showAndWait();

    }


}


