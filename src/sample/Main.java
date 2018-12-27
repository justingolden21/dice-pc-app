package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;


    Label rollLabel;

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Die Roller");

        button = new Button();
        button.setText("D4");
        button.setOnAction(e -> {
            rollLabel.setText( "Rolled D4: " + Integer.toString(Util.getRoll(4) ) );
        });

        rollLabel = new Label("Roll: ");

        BorderPane layout = new BorderPane();
        HBox hbox = new HBox();
        layout.setTop(hbox);
        layout.setBottom(button);
        layout.setCenter(rollLabel);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

