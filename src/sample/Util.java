package sample;

public class Util {

    static int getRoll(int sides) {
        return (int) Math.floor(Math.random() * sides) + 1;
    }

    public static void displayRoll(int roll) {
        Main.rollLabel.setText("Rolled D" + Integer.toString(roll) + ": " + Integer.toString(getRoll(roll) ) );
    }

}
