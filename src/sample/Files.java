package sample;

import java.io.*;

public class Files {

    public static void appendText(String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true) ) ) {
            bw.write(text);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearText() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("log.txt", false), false);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getText() {
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt") ) ) {
            String line;
            String lines = "";
            while ((line = br.readLine()) != null) {
                lines += line + ";";
            }
            return lines.split(";");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

}
