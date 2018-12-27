package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button d4button, d6button, d8button;

    public static Label rollLabel;

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Die Roller");

        //http://iconhandbook.co.uk/reference/chart/windows/
        window.getIcons().addAll(
                new Image("/img/icon64.png"),
                new Image("/img/icon32.png"),
                new Image("/img/icon16.png")
        );

        d4button = new Button();
        d6button = new Button();
        d8button = new Button();

        d4button.setText("D4");
        d6button.setText("D6");
        d8button.setText("D8");

        d4button.setOnAction(e -> {
            Util.displayRoll(4);
        });
        d6button.setOnAction(e -> {
            Util.displayRoll(6);
        });
        d8button.setOnAction(e -> {
            Util.displayRoll(8);
        });

        rollLabel = new Label("Roll: ");

        BorderPane layout = new BorderPane();

        FlowPane flowpane = new FlowPane();
        flowpane.getChildren().addAll(d4button, d6button, d8button);
        
        layout.setTop(flowpane);
        layout.setCenter(rollLabel);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

