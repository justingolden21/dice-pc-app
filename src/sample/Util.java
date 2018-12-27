package sample;

public class Util {

    static int maxRolls = 1000;

    static int getRoll(int sides) {
        return (int) Math.floor(Math.random() * sides) + 1;
    }

    public static void doRolls(int sides) {

        int numRolls;
        try {
            numRolls = Integer.parseInt(Main.numDice.getText() );
        } catch(NumberFormatException e) {
            numRolls = 1;
        }
        numRolls = Math.max(Math.min(maxRolls, numRolls), 1);
        Main.numDice.setText(Integer.toString(numRolls) );

        int[] rolls = new int[numRolls];
        int sum = 0;
        String rollList = "(";
        for(int i=0; i<numRolls; i++) {
            rolls[i] = getRoll(sides);
            sum += rolls[i];
            rollList += (i==0 ? "" : ", ") + Integer.toString(rolls[i]);
        }
        rollList += ")";

        if(numRolls==1) {
            rollList = "";
        }

        Main.rollLabel.setText("Rolled " + Integer.toString(numRolls) + "D" + Integer.toString(sides) + ": " + Integer.toString(sum) + " " + rollList );
    }
}
