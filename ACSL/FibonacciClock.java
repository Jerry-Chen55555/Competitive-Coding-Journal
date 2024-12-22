import java.io.*;
import java.util.Arrays;

public class FibonacciClock {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] fibonaccis = { 1, 1, 2, 3, 5 };

        for (int i = 0; i < 5; i++) {
            String[] tokenStrings = br.readLine().split(" ");
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