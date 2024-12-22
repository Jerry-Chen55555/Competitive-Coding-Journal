import java.util.*;
import java.io.*;

public class YearOfTheCow {
    public static int mod(int x, int y) {
        if (x % y < 0) {
            return x % y + y;
        }
        return x % y;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> c = new HashMap<>();
        c.put("Bessie", 0);
        String[] z = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            if (tokens[3].equals("next")) {
                if (Arrays.asList(z).indexOf(tokens[4]) == mod(c.get(tokens[7]), 12)) {
                    c.put(tokens[0], c.get(tokens[7]) + 12);
                }
                else {
                    c.put(tokens[0], c.get(tokens[7]) + mod(Arrays.asList(z).indexOf(tokens[4]) - mod(c.get(tokens[7]), 12), 12));
                }
            }
            else {
                if (Arrays.asList(z).indexOf(tokens[4]) == mod(c.get(tokens[7]), 12)) {
                    c.put(tokens[0], c.get(tokens[7]) - 12);
                }
                else {
                    c.put(tokens[0], c.get(tokens[7]) - mod(mod(c.get(tokens[7]), 12) - Arrays.asList(z).indexOf(tokens[4]), 12));
                }
            }
        }
        
        pw.println(Math.abs(c.get("Elsie")));
        pw.close();
    }
}
