import java.io.*;
import java.util.Arrays;

public class FibonacciClock {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            char key = input.charAt(0);
            System.out.println(Arrays.toString(tokenStrings));
            int hours = 0;
            int minutes = 0;
            for (int j = 0; j < tokenStrings.length; j++) {
                if (tokenStrings[j].equals("R") || tokenStrings[j].equals("B")) {
                    hours += fibonaccis[j];
                }
                if (tokenStrings[j].equals("G") || tokenStrings[j].equals("B")) {
                    minutes += fibonaccis[j] * 5;
                }
            }
            System.out.println((i + 1) + ". " + ("00").substring(0, 2 - (hours + "").length()) + hours + ":"
                    + ("00").substring(0, 2 - (minutes + "").length()) + minutes);
        }
        br.close();
    }
}