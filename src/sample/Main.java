package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    final static int WINDOW_WIDTH = 500;
    final static int WINDOW_HEIGHT = 500;
    final static int WINDOW_MIN_WIDTH = 250;
    final static int WINDOW_MIN_HEIGHT = 250;

    Button d4button, d6button, d8button, d10button, d12button, d20button, customDieButton, historyButton;

    public static Label rollLabel;

    public static TextField numDice, customSides;

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Die Roller");

        window.setMinWidth(WINDOW_MIN_WIDTH);
        window.setMinHeight(WINDOW_MIN_HEIGHT);

        //http://iconhandbook.co.uk/reference/chart/windows/
        //http://iconhandbook.co.uk/reference/chart/osx/
        //https://convertico.com/
        //https://cloudconvert.com/png-to-icns
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

        d4button = new Button("D4");
        d6button = new Button("D6");
        d8button = new Button("D8");
        d10button = new Button("D10");
        d12button = new Button("D12");
        d20button = new Button("D20");
        customDieButton = new Button("Custom Die");
        historyButton = new Button("History ");

        d4button.setOnAction(e -> Rolls.doRolls(4) );
        d6button.setOnAction(e -> Rolls.doRolls(6) );
        d8button.setOnAction(e -> Rolls.doRolls(8) );
        d10button.setOnAction(e -> Rolls.doRolls(10) );
        d12button.setOnAction(e -> Rolls.doRolls(12) );
        d20button.setOnAction(e -> Rolls.doRolls(20) );
        customDieButton.setOnAction(e -> Rolls.doRolls(-1) );

        historyButton.setOnAction(e -> Alert.display("History", Files.getText() ) );

        customDieButton.getStyleClass().add("wideButton");
        historyButton.getStyleClass().add("wideButton");

        rollLabel = new Label("Roll: ");

        numDice = new TextField();
        numDice.setText("1");

        customSides = new TextField();
        customSides.setText("2");

        Label customSidesLabel = new Label("    Custom Die Sides: ");
        Label numDiceLabel = new Label("Number of Dice: ");

        BorderPane layout = new BorderPane();

        FlowPane flowpane = new FlowPane();
        flowpane.getChildren().addAll(numDiceLabel, numDice, d4button, d6button, d8button, d10button, d12button, d20button, customSidesLabel, customSides, customDieButton);

        layout.setTop(flowpane);
        layout.setCenter(rollLabel);

        layout.setBottom(historyButton);

        //https://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
        numDice.textProperty().addListener( e ->  {
            String textVal = numDice.getText();
            if(!textVal.matches("\\d*")) { //digits only
                numDice.setText(textVal.replaceAll("[^\\d]", ""));
            }
            if(textVal.length()>4) { //4 is max digits for 1000 which is maxRolls
                numDice.setText(textVal.substring(0,4) );
            }
        });
        customSides.textProperty().addListener( e ->  {
            String textVal = customSides.getText();
            if(!textVal.matches("\\d*")) { //digits only
                customSides.setText(textVal.replaceAll("[^\\d]", ""));
            }
            if(textVal.length()>9) { //max 9 digits
                customSides.setText(textVal.substring(0,9) );
            }
        });

        Scene mainScene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);
        mainScene.getStylesheets().add("/css/styles.css");
        window.setScene(mainScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

