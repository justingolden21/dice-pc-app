package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button d4button;
    
    Label rollLabel;

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Die Roller");

        window.getIcons().addAll(
                new Image("/img/icon64.png"),
                new Image("/img/icon32.png"),
                new Image("/img/icon16.png")
        );

        d4button = new Button();
        d4button.setText("D4");
        d4button.setOnAction(e -> {
            rollLabel.setText( "Rolled D4: " + Integer.toString(Util.getRoll(4) ) );
        });

        rollLabel = new Label("Roll: ");

        BorderPane layout = new BorderPane();
        HBox hbox = new HBox();
        layout.setTop(hbox);
        layout.setBottom(d4button);
        layout.setCenter(rollLabel);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

