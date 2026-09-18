import java.util.*;
import java.io.*;

public class SquarePasture {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter("notlast.out");

        HashMap<String, Integer> cows = new HashMap<>(Map.of("Bessie", 0, "Elsie", 0, "Daisy", 0, "Gertie", 0, "Annabelle", 0, "Maggie", 0, "Henrietta", 0));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int milk = Integer.parseInt(st.nextToken());
            cows.put(name, cows.remove(name) + milk);
        }

        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (String key : cows.keySet()) {
            if (cows.get(key) < min) {
                min = cows.get(key);
            }
        }
        for (String key : cows.keySet()) {
            if (cows.get(key) < min2 && cows.get(key) > min) {
                min2 = cows.get(key);
            }
        }

        int counter = 0;
        for (String key : cows.keySet()) {
            if (cows.get(key) == min2) {
                counter++;
            }
        }
        if (counter == 1) {
            for (String key : cows.keySet()) {
                if (cows.get(key) == min2) {
                    pw.println(key);
                }
            }
        } else {
            pw.println("Tie");
        }
        pw.close();
        br.close();
    }
}