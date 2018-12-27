package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;

//    Text text;

    Label rollLabel;

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Die Roller");

        button = new Button();
        button.setText("Click me");
        button.setOnAction(e -> {
            rollLabel.setText( Integer.toString(Util.getRoll(4) ) );
        });

//        text = new Text();
        rollLabel = new Label("Roll: ");
//        text.setText(rollLabel);




        BorderPane layout = new BorderPane();
        HBox hbox = new HBox();
        layout.setTop(hbox);
        layout.setBottom(button);
        layout.setCenter(rollLabel);

//        layout.getChildren().addAll(button, rollLabel);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

