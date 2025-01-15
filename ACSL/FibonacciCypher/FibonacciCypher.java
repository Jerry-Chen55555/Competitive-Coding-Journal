package FibonacciCypher;
import java.io.*;
import java.util.*;

public class FibonacciCypher {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> fibonaccis = new ArrayList<>(Arrays.asList(1, 1, 2));

        for (int i = 0; i < 5; i++) {
            String output = "";
            String input = br.readLine();

            char key = input.charAt(0);
            String text = input.substring(2);
            
            for (int j = 0; j < text.length(); j++) {
                if (fibonaccis.size() < j + 2) {
                    fibonaccis.add(fibonaccis.get(j) + fibonaccis.get(j-1));
                }
                int intOutput = key + fibonaccis.get(j + 1) + text.charAt(j);
                if (key + fibonaccis.get(j + 1) > 122) {
                    intOutput -= 26;
                }
                output += (intOutput) + " ";
            }
            System.out.println(output);
            System.out.println(fibonaccis);
        }
        br.close();
    }
}