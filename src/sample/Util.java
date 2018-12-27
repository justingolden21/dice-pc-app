package sample;

public class Util {

    public static int getRoll(int sides) {
        return (int) Math.floor(Math.random() * sides) + 1;
    }

}
