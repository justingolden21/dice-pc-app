package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    final int WINDOW_WIDTH = 250;
    final int WINDOW_HEIGHT = 250;


    Button d4button, d6button, d8button;

    public static Label rollLabel;

    public static TextField numDice;

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
            Util.doRolls(4);
        });
        d6button.setOnAction(e -> {
            Util.doRolls(6);
        });
        d8button.setOnAction(e -> {
            Util.doRolls(8);
        });

        rollLabel = new Label("Roll: ");

        numDice = new TextField();
        numDice.setText("1");

        BorderPane layout = new BorderPane();

        FlowPane flowpane = new FlowPane();
        flowpane.getChildren().addAll(numDice, d4button, d6button, d8button);

        layout.setTop(flowpane);
//        layout.setCenter(numDice);
        layout.setBottom(rollLabel);

        // force the field to be numeric only
        //https://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
        numDice.textProperty().addListener( e ->  {
            String textVal = numDice.getText();
            if(!textVal.matches("\\d*")) {
                numDice.setText(textVal.replaceAll("[^\\d]", ""));
            }
            if(textVal.length()>4) { //4 is max digits for 1000 which is maxRolls
                numDice.setText(textVal.substring(0,4) );
            }
        });

        Scene scene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

